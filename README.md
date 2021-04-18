# Search-information-interface
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# I- Objectif:
faire in interface qui chercher une information donnée sur un ensemble du document textual , on construit 3 méthode de recherche d'information :

  # 1)recherche avec le nom de document:
  il fair la recherche du document avec le même nom donnée sur le bar de recherche, pour cette méthode on peu utilise cette requet:
  
                        sql="SELECT * FROM document WHERE Name_document LIKE '%"+nom+"%'";
			(avec <nom> et le mot entre par le utilisateur).
  
  alors il va commparer le nom donnée avec les nom des documents sur la base de donnée et il va afficher les documents avec le même nom donnée sur le bar de recherche.
  pour plus de information voir le fiche java name.java.


  # 2)recherche avec le auteur de document:
  il fair la recherche du document et l'auteur avec le même nom donnée sur le bar de recherche, pour cette méthode on peu utilise cette 2 requet.
  *le premier :
  
           sql="SELECT * FROM document WHERE Author LIKE '%"+auteur_nom+"%'";
	   (avec <auteur_nom> et le mot entre par le utilisateur).
	   
  alors il va commparer le nom de auteur donnée avec les nom de auteur des documents sur la base de donnée et il va afficher les documents avec le même nom de auteur donnée sur   le bar de recherche.
  *la deuxième :
  
           sql2 ="select * from auteur where Family_name_author=? ";           
            stmt=conn.prepareStatement(sql2);
            stmt.setString(1,txt_auteur.getText());
            rs=stmt.executeQuery();
            
  alors il va commparer le nom de auteur donnée avec les nom des auteurs sur la base de donnée et il va afficher les information de l'auteur avec le même nom de auteur donnée     sur le bar de recherche.            
  pour plus de information voir le fiche java author.java


  # 3)recherche avec le contunu de document:
  il fair la recherche de mot sur un ensemble du documents avec le même mot donnée sur le bar de recherche, pour cette méthode on peu utilise l'indextion des document,
  aprer ça en peu rechercher sur les document avec cette code :
  
                    ArrayList<String> mylist=new ArrayList<String>();
                    mylist=tester.search(mot);(avec <mot> et le mot entre par le utilisateur).
		    
  pour plus de information voir le fiche java word.java, Indexer.java, Searcher.java,LuceneConstants.java .
  
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
# II- Base de donnée :
base de donnée est essentiel pour la fonctionnement de project, et on peu facilement la connecter avec le projet .
*avec cette méthode:

                      Class.forName("org.sqlite.JDBC");
                      Connection conn =DriverManager.getConnection("jdbc:sqlite:auteur.db"); (avec <auteur.db> est la base de donnée).
   
*la base de donnée est construire de 3 tableau:
  
  # 1)login:
  cette tableau et mis en place pour le accéc de utisateur (pour le moment le username est :1 et mot de passe est:1).
  
     CREATE TABLE "login" (
	"ID"	INTEGER NOT NULL,
	"USERNAME"	VARCHAR NOT NULL,
	"PASSWORD"	VARCHAR NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
    )
 # 2)document:
 cette tableau et mis en place pour le stockage de (nom, auteur et le chamin) des documents.
 
     CREATE TABLE "document" (
	"ID"	INTEGER NOT NULL,
	"Author"	VARCHAR NOT NULL,
	"Name_document"	VARCHAR NOT NULL,
	"Path_document"	VARCHAR NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
    )
  
  # 3)auteur:
  cette tableau et mis en place pour le stockage de (nom,prenom et bio) des auteur des documents.
  
  
     CREATE TABLE "auteur" (
	"ID"	INTEGER NOT NULL,
	"Family_name_author"	VARCHAR NOT NULL,
	"Name_author"	VARCHAR NOT NULL,
	"Bio_author"	VARCHAR NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
     )
  
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
# III- Accée au inteface:
 pour entre a l'interface et fair des recherches il faux d'abord avoir la pemition , et la en parle sur la fenetre  Login.java,
 qui vairifier ton compte(username et password) si tu existe sur la base de donnée ou non.
 *avec cette requet:
 
                    sql = "select ID,USERNAME,PASSWORD from login Where (USERNAME =? and PASSWORD =?)";
                   try{
           int count =0;
           pst=conn.prepareStatement(sql);          
           pst.setString(1,txt_username.getText());//getText from txt_username and compare it to colome
           pst.setString(2,txt_password.getText());
           rs=pst.executeQuery();
           
si ton compte existe sur la base de donnée alors le fenetre de choix ovrire
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
# IV- Choisir le méthode de recherche:
 *nous a crée 3 méthode de recherch :
    
      1)recherche avec le nom de document.
      2)recherche avec le auteur de document.
      3)recherche avec le contunu de document.
      
# il faux just choisire votre méthode:
et il va ovrire pour ferre la recherche.

 -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# V- Ovriture de document:
pour l'accée au document aprer la recherche en utilise la méthode de MouseClick pour la séléctionement de document qui nous vons ovrir.
*et cette méthode pour l'ovriture de document:
         
	 private void table_docMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // click to open the document:
        int index = table_doc.getSelectedRow();
        TableModel model = table_doc.getModel();
        String p="";
        lb1.setText(model.getValueAt(index, 0).toString());//mettre le chemp dans path_doc
        File filepath=new File(lb1.getText());
        try {
            Desktop.getDesktop().open(filepath);  # Ovriture de document
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
  
  -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# VI- Capture de fenetre:

# 1)Login.java.

![login](https://user-images.githubusercontent.com/61596276/115130985-2f530400-9fec-11eb-8cae-ed665c15306b.PNG)
![login_succeed](https://user-images.githubusercontent.com/61596276/115154220-aed6e680-a071-11eb-991b-da8e25cb43e1.PNG)
![login_fail](https://user-images.githubusercontent.com/61596276/115154227-b1d1d700-a071-11eb-8810-a120e9d89180.PNG)

# 2)Choice.java.

![choice](https://user-images.githubusercontent.com/61596276/115131010-66c1b080-9fec-11eb-9be3-4e9eadf65214.PNG)


# 3)name.java.

![name](https://user-images.githubusercontent.com/61596276/115131025-835de880-9fec-11eb-8bb8-98e4c3b90e85.PNG)
![name_resultat](https://user-images.githubusercontent.com/61596276/115154048-cf527100-a070-11eb-8dde-184623f8fcad.PNG)
![name_fail](https://user-images.githubusercontent.com/61596276/115154239-bc8c6c00-a071-11eb-8e2c-421d12aa68a3.PNG)


# 4)author.java.

![author](https://user-images.githubusercontent.com/61596276/115154024-b649c000-a070-11eb-9b89-182e840c8ea7.PNG)
![author_resultat](https://user-images.githubusercontent.com/61596276/115154022-b47ffc80-a070-11eb-912e-856f10dbac49.PNG)
![author_fail](https://user-images.githubusercontent.com/61596276/115154284-feb5ad80-a071-11eb-91b5-2c350dae1ec0.PNG)

# 5)word.java.
![word](https://user-images.githubusercontent.com/61596276/115131035-9a9cd600-9fec-11eb-8183-e9e4704e9213.PNG)
![word_resultat](https://user-images.githubusercontent.com/61596276/115154080-ee510300-a070-11eb-9da6-c8f718293e43.PNG)
![name_fail](https://user-images.githubusercontent.com/61596276/115154293-083f1580-a072-11eb-9459-eabc1b48674a.PNG)

  
  
  
