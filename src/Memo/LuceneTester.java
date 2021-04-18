/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memo;

/**
 *
 * @author user
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
   String indexDir = "C:\\Users\\user\\Desktop\\la mémoire\\LuceneFirstApplication\\Index";
   String dataDir = "C:\\Users\\user\\Desktop\\la mémoire\\Lucene-Tutorials-master\\test data";
   Indexer indexer;
   Searcher searcher;

   public static void main(String[] args) {
      LuceneTester tester;
      try {
         tester = new LuceneTester();
         tester.createIndex();//call the function creatIndex to index the document
         // now we have to pop up the window 
         //take the word from the textfield and stock it in a String
         
        ///////
        JFrame frame =new JFrame();
        JTable table =new JTable();
        
        Object[] colums ={"chemp"};
        DefaultTableModel model = new   DefaultTableModel();
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        
        table.setBackground(Color.cyan);
        table.setForeground(Color.white);
        Font font =new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        
        JTextField search_word=new JTextField();//the text fiel that we want to put our word on
        
        JButton Searching =new JButton("Search");// the search button
        
        search_word.setBounds(20,220,100,25);
        
        Searching.setBounds(150, 220,100, 25 );
        
        JScrollPane pane =new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        frame.add(search_word);
;
        
        frame.add(Searching);
        
        Object[] row = new Object[11];
        //insert
        Searching.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //row[0]=search_word.getText();
                String word=search_word.getText();
                try {
                    //tester.search(word);
                    int i; 
                    ArrayList<String> mylist=new ArrayList<String>();
                    mylist=tester.search(word);
                    System.out.println("les list sont:____________________________________________________________");
                    for(i=0;i<mylist.size();i++){
                        
                        //System.out.println("list:"+mylist.get(i));//vrai
                    row[0]=mylist.get(i);
                    model.addRow(row);
                    }
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(LuceneTester.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(LuceneTester.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
            }
        });
        
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        ///// 
         
         
         //put the word in tester.search(work) 
         tester.search("Suresh");
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }

   void createIndex() throws IOException {
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }

   ArrayList<String> search(String searchQuery) throws IOException, ParseException {
      searcher = new Searcher(indexDir);
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
   
      System.out.println(hits.totalHits +
         " documents found. Time :" + (endTime - startTime));
      ArrayList<String> list=new ArrayList<String>();
      int i=0;
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "+ doc.get(LuceneConstants.FILE_PATH));
            list.add(doc.get(LuceneConstants.FILE_PATH));
            //System.out.println("list:"+list.get(i)+"\n");
            //i++;
            
      }
      searcher.close();
       return list;
       
   }
}
