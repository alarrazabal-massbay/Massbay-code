import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Main {
    public static void main(String[] args) throws TesseractException, FileNotFoundException { 
        File card_folder = new File("resources");
        File[] card_files = card_folder.listFiles();
        List<Card> card_deck = new ArrayList<>();

        //CREATE OUT FOLDER
        File folder_out = new File("out");
        if (!folder_out.exists()) {
            folder_out.mkdir();  
        }

        //MAKE LOOP TO GO THROUGH CARD FOLDER AND WRITE INTO OUT FOLDER
        int i = 0; //<- Card_deck index
        for (File next_card : card_files) {
            String card_file_name = next_card.getName(); //<- Should return card1.jpg, card2.jpg, etc.

            //NEED 2 TESSERACT OBJECTS FOR TITLE AND BODY

            //TESSERACT 1: TITLE
            Tesseract reader_title = new Tesseract(); //<- the object that knows how to read images  
            reader_title.setDatapath("title_body"); //<- the folder where  .traineddata "language" files live
            reader_title.setLanguage("title"); //<- the name of the language file you want to use (e.g "someFont" for a file called someFont.traineddata that lives in "someFolder")
            File imageFile_title = new File( "resources/" + card_file_name ); //<- the image you want to read
            Rectangle title_box = new Rectangle(55, 55, 400, 35); //<- the rectangle in that image that contains that text -- the (x,y) of the top-left corner, then width x height
            String result_title = reader_title.doOCR(imageFile_title, title_box);  //<- convert that box of that image into text!!

            // TESSERACT EXTRA CREDIT: TYPE
            Tesseract reader_type = new Tesseract();
            reader_type.setDatapath("title_body");
            reader_type.setLanguage("title");
            File imageFile_type = new File( "resources/" + card_file_name );
            Rectangle type_box = new Rectangle(55, 535, 400, 35);
            String result_type = reader_type.doOCR(imageFile_type, type_box);
            String result_subtype = "";

            if ( result_type.contains(" - ") ) {
                String[] type_subtype = result_type.split(" - ");
                result_type = type_subtype[0];
                result_subtype = type_subtype[1];
            }

            //TESSERACT 2: BODY
            Tesseract reader_body = new Tesseract();   
            reader_body.setDatapath("title_body"); 
            reader_body.setLanguage("body");
            File imageFile_body = new File( "resources/" + card_file_name ); 
            Rectangle body_box = new Rectangle(50, 600, 565, 260); 
            String result_body = reader_body.doOCR(imageFile_body, body_box);
        
            //ADD TO CARD DECK
            Card card = new Card(result_title, result_type, result_body);
            if ( result_subtype.length() > 0 ) {
                card.setSubtype(result_subtype);
            }
            card_deck.add(card);
            
            //START WRITING INTO OUT FOLDER
            String card_num_name = "\\" + next_card.getName().substring(0, next_card.getName().length() - 3) + "txt";
            File card_text_file = new File(folder_out.getAbsolutePath() + card_num_name);
            PrintWriter card_writer = new PrintWriter(card_text_file);

            card_writer.println(
                card_deck.get(i).getTitle() +
                "------------------------------------\n" +
                card_deck.get(i).getType()
            ); if (card_deck.get(i).getSubtype() != null) {
                card_writer.println(card_deck.get(i).getSubtype());
            } card_writer.println(card_deck.get(i).getBody());
            card_writer.close();
            i++; //<- iterate each card in deck
        }
    }
}
