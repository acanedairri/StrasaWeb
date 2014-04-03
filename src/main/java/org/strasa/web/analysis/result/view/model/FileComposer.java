package org.strasa.web.analysis.result.view.model;


import java.util.HashMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;
import org.zkoss.zul.Window;
 
public class FileComposer extends SelectorComposer<Component> {
    private static final long serialVersionUID = 3814570327995355261L;
     
    @Wire
    private Window demoWindow;
    @Wire
    private Tree tree;
 
    private AdvancedFileTreeModel fileTreeModel;
 
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);     
        fileTreeModel = new AdvancedFileTreeModel(new FileList().getRoot());
        tree.setItemRenderer(new FileTreeRenderer());
        tree.setModel(fileTreeModel);
    }
 
    /**
     * The structure of tree
     * 
     * <pre>
     * &lt;treeitem>
     *   &lt;treerow>
     *     &lt;treecell>...&lt;/treecell>
     *   &lt;/treerow>
     *   &lt;treechildren>
     *     &lt;treeitem>...&lt;/treeitem>
     *   &lt;/treechildren>
     * &lt;/treeitem>
     * </pre>
     */
    private final class FileTreeRenderer implements TreeitemRenderer<FileModelTreeNode> {
        @Override
        public void render(final Treeitem treeItem, FileModelTreeNode treeNode, int index) throws Exception {
            FileModelTreeNode ctn = treeNode;
            FileModel filename = (FileModel) ctn.getData();
            Treerow dataRow = new Treerow();
            dataRow.setParent(treeItem);
            treeItem.setValue(ctn);
            treeItem.setOpen(ctn.isOpen());
 
            if (!isFolder(filename)) { // Contact Row
                Hlayout hl = new Hlayout();
                hl.appendChild(new Image("/images/" + filename.getFileicon()));
                hl.appendChild(new Label(filename.getFilename()));
                hl.setSclass("h-inline-block");
                Treecell treeCell = new Treecell();
                treeCell.appendChild(hl);
                dataRow.setDraggable("true");
                dataRow.appendChild(treeCell);
                dataRow.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
                    @Override
                    public void onEvent(Event event) throws Exception {
                        FileModelTreeNode clickedNodeValue = (FileModelTreeNode) ((Treeitem) event.getTarget().getParent())
                                .getValue();
                        Window w = new Window("ZK IM - " + ((FileModel) clickedNodeValue.getData()).getFilename(), "normal",
                                true);
                        w.setPosition("parent");
                        w.setParent(demoWindow);
                        HashMap<String, String> dataArgs = new HashMap<String, String>();
                        dataArgs.put("name", clickedNodeValue.getData().getFilename());
                        Executions.createComponents("fileviewer.zul", w, dataArgs);
                        w.doOverlapped();
                    }
                });
            } else { // Category Row
                dataRow.appendChild(new Treecell(filename.getFoldername()));
            }
            // Both category row and contact row can be item dropped
            dataRow.setDroppable("true");
            dataRow.addEventListener(Events.ON_DROP, new EventListener<Event>() {
                @SuppressWarnings("unchecked")
                @Override
                public void onEvent(Event event) throws Exception {
                    // The dragged target is a TreeRow belongs to an
                    // Treechildren of TreeItem.
                    Treeitem draggedItem = (Treeitem) ((DropEvent) event).getDragged().getParent();
                    FileModelTreeNode draggedValue = (FileModelTreeNode) draggedItem.getValue();
                    Treeitem parentItem = treeItem.getParentItem();
                    fileTreeModel.remove(draggedValue);
                    if (isFolder((FileModel) ((FileModelTreeNode) treeItem.getValue()).getData())) {
                        fileTreeModel.add((FileModelTreeNode) treeItem.getValue(),
                                new DefaultTreeNode[] { draggedValue });
                    } else {
                        int index = parentItem.getTreechildren().getChildren().indexOf(treeItem);
                        if(parentItem.getValue() instanceof FileModelTreeNode) {
                            fileTreeModel.insert((FileModelTreeNode)parentItem.getValue(), index, index,
                                    new DefaultTreeNode[] { draggedValue });
                        }
                         
                    }
                }
            });
 
        }
 
        private boolean isFolder(FileModel filename) {
            return filename.getFilename() == null;
        }
    }
}