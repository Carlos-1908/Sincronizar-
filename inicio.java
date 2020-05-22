import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;

public class CargaCarpetaImagen implements ActionListener{
  JFrame frame;
  String listaImg[];
  JLabel visor;
  File archi;
  int i;

  public CargaCarpetaImagen() {    
    f=new JFrame();
    try{
      archi=new File((getClass().getResource("\\images\\")).toURI());
    }catch(URISyntaxException e){ System.out.println("Error en la ruta de la imagen");}
    if(!archi.exists())
      JOptionPane.showMessageDialog(f, "Carpeta de imagenes inexistente!", "Lo sentimos :(", JOptionPane.ERROR_MESSAGE);
    else{ 
      listaImg= archi.list();
    if(listaImg!=null){
      i=0;
      visor=new JLabel(new ImageIcon(getClass().getResource("images\\"+listaImg[i])));
      f.add(visor);
      visor.addActionListener(this);  
    }
    f.setSize(600,600);
    f.setVisible(true);
    }
  }

   public void actionPerformed(ActionEvent e){
      i++;
      if(i== listaImg.length) i=0;
      visor.setIcon(new ImageIcon(getClass().getResource("images\\"+listaImg[i])));
      visor.updateUI();
    }
   public static void main(String args[]){
     new CargaCarpetaImagen();
    }
}