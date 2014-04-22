package org.strasa.web.analysis.result.view.model;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.spring.security.model.SecurityUtil;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
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
    private static String RESULT_ANALYSIS_PATH="/resultanalysis/"+SecurityUtil.getUserName()+"/";
 
    private AdvancedFileTreeModel fileTreeModel;
    AMedia fileContent;
 
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
			dataRow.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {

					FileModelTreeNode clickedNodeValue = (FileModelTreeNode) ((Treeitem) event.getTarget().getParent())
							.getValue();
					FileModel fm=clickedNodeValue.getData();
					if(isFolder(fm)){
						Window w = new Window(((FileModel) clickedNodeValue.getData()).getFoldername(), "normal",
								true);
						w.setPosition("parent");
						w.setParent(demoWindow);
						HashMap<String, String> dataArgs = new HashMap<String, String>();
						dataArgs.put("name", clickedNodeValue.getData().getFilename());
						//                    String pathFile="/resultanalysis/"

						w.doOverlapped();
					}
				}
			});
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

						FileModel f=(FileModel) clickedNodeValue.getParent().getData();
						String foldername=f.getFoldername();
						String rootFolder=clickedNodeValue.getParent().getParent().getData().getFoldername();
						String filenamepath=RESULT_ANALYSIS_PATH+rootFolder+"/"+foldername+"/"+clickedNodeValue.getData().getFilename();

						Window w = new Window(((FileModel) clickedNodeValue.getData()).getFilename(), "normal",
								true);
						w.setPosition("parent");
						w.setParent(demoWindow);
						w.setMaximizable(true);
						w.setMinheight(500);
						w.setMinwidth(500);
						w.setPosition("center");
					
				
						HashMap<String, String> dataArgs = new HashMap<String, String>();
						dataArgs.put("name", clickedNodeValue.getData().getFilename());
						
						if(clickedNodeValue.getData().getFilename().contains(".png")){

							System.out.println(filenamepath);
							dataArgs.put("imageName", filenamepath);
							Executions.createComponents("analysis/imgviewer.zul",w, dataArgs);
							w.doOverlapped();
						
						}else if(clickedNodeValue.getData().getFilename().contains(".pdf")){

							String filePath = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
							File fpdf = new File(filePath+filenamepath);

							byte[] buffer = new byte[(int) fpdf.length()];
							FileInputStream fs = new FileInputStream(fpdf);
							fs.read(buffer);
							fs.close();
							ByteArrayInputStream is = new ByteArrayInputStream(buffer);
							fileContent = new AMedia("report", "pdf", "application/pdf", is);
							HashMap<String, AMedia> dataArgsPdf = new HashMap<String, AMedia>();
							dataArgsPdf.put("pdfFile", fileContent);

							Executions.createComponents("analysis/pdfviewer.zul", w, dataArgsPdf);
							w.doOverlapped();


						}else if(clickedNodeValue.getData().getFilename().contains(".txt")){
							String filePath = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
							
							File fpdf = new File(filePath+filenamepath);

							byte[] buffer = new byte[(int) fpdf.length()];
							FileInputStream fs = new FileInputStream(fpdf);
							fs.read(buffer);
							fs.close();
							ByteArrayInputStream is = new ByteArrayInputStream(buffer);
							fileContent = new AMedia("report", "text", "text/plain", is);
							HashMap<String, AMedia> dataArgsTxt = new HashMap<String, AMedia>();
							dataArgsTxt.put("txtFile", fileContent);
						
//							Executions.getCurrent().sendRedirect(urlName,"_blank");
//							Executions.createComponents("textviewer.zul", w, dataArgsTxt);
							String port = ( Executions.getCurrent().getServerPort() == 80 ) ? "" : (":" + Executions.getCurrent().getServerPort());
//							String url = Executions.getCurrent().getScheme() + "://" + Executions.getCurrent().getServerName() + port + Executions.getCurrent().getContextPath() +  Executions.getCurrent().getDesktop().getRequestPath();
							String url = Executions.getCurrent().getScheme() + "://" + Executions.getCurrent().getServerName() + port + Executions.getCurrent().getContextPath() + filenamepath;
							System.out.println(url);
							Executions.getCurrent().sendRedirect(url,"_blank");
							w.detach();

						}
						
						else{
/*							HashMap<String, String> dataArgsTxt2 = new HashMap<String, String>();
							dataArgsTxt2.put("txtFile", "Test");
							Executions.createComponents("testprint.zul", w, dataArgsTxt2);
							w.doOverlapped();*/
							
							
						}
						


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