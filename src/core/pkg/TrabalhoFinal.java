package core.pkg;

/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public class TrabalhoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Window w = Window.getInstance();
        w.addRegion(300, 300, 10, 5); //Região A
        w.addRegion(8, 125, 125, 400); //Região B
        w.addRegion(57, 35, 109, 85); //Região C
        w.addIcon(330,0); //Ícone 1
        w.addIcon(330,400); //Ícone 2
        w.addIcon(200,150); //Ícone 3
        w.addIcon(130,350); //Ícone 4
        w.addIcon(130,350); //Ícone 5
        w.addIcon(130,350); //Ícone 6
        w.removeIcon(w.getIcons().get(4));
        w.addClick(125,250); //Esperado: Região B
        w.addClick(200,150); //Esperado: Região A
        w.addClick(100,50); //Esperado: Região C
        w.addClick(330,200); //Esperado: Ícone 1
        w.addClick(135,400); //Esperado: Ícone 4
        w.removeIcon(w.getIcons().get(3));
        w.addClick(135,400); //Esperado: Ícone 6
        System.out.println(w);
        System.out.println();      
    }
    
}
