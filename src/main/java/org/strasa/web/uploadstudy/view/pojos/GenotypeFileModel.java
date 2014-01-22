package org.strasa.web.uploadstudy.view.pojos;

import java.io.File;

public class GenotypeFileModel {

		public String name;
		public File tempFile;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public File getFilepath() {
			return tempFile;
		}

		public void setFilepath(File filepath) {
			this.tempFile = filepath;
		}

		public GenotypeFileModel(String name, File path) {
			this.name = name;
			this.tempFile = path;
		}

	}