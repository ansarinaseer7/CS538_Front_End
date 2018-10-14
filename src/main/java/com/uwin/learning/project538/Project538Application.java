package com.uwin.learning.project538;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project538Application {
	static int counter = 0;

	public static void main(String[] args) throws IOException {
		/*
		String indexPath = "C:/Users/ansar/OneDrive/Documents/60-538/data/citeseer2_index";
		String docsPath = "C:/Users/ansar/OneDrive/Documents/60-538/data/citeseer2";
		System.out.println("Indexing to directory '" + indexPath + "'...");
		Directory dir = FSDirectory.open(Paths.get(indexPath));
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(dir, iwc);
		indexDocs(writer, Paths.get(docsPath));
		writer.close();*/
		
		SpringApplication.run(Project538Application.class, args);
	}
	
	
	//methods
	static void indexDocs(final IndexWriter writer, Path path) throws IOException {
		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				indexDoc(writer, file);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	/** Indexes a single document */
	static void indexDoc(IndexWriter writer, Path file) throws IOException {
		InputStream stream = Files.newInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
		String title = br.readLine();
		Document doc = new Document();
		doc.add(new StringField("path", file.toString(), Field.Store.YES));
		doc.add(new TextField("contents", br));
		doc.add(new StringField("title", title, Field.Store.YES));
		writer.addDocument(doc);
		System.out.println("indexing " + counter + "-th file " + file.getFileName());
		counter++;
		
	}
}
