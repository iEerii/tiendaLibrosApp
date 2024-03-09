package mx.com.emeru.tienda_libros.presentacion;

import mx.com.emeru.tienda_libros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class LibroForm extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField libroTexto;
    private JTextField autorTexto;
    private JTextField precioTexto;
    private JTextField existenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();
        agregarButton.addActionListener(e -> {

        });
    }

    public void iniciarForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanhoPantalla = toolkit.getScreenSize();
        int x = (tamanhoPantalla.width - getWidth()/2);
        int y = (tamanhoPantalla.height - getHeight()/2);
        setLocation(x, y);
    }

    private void createUIComponents() {
        this.tablaModeloLibros = new DefaultTableModel(0, 5);
        String[] cabeceros = {"Id", "Libro", "Autor", "Precio", "Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(cabeceros);
        //Intanciar el objeto JTable
        this.tablaLibros = new JTable(tablaModeloLibros);
        listarLibros();
    }

    private void listarLibros(){
        //Limpiar la tabla
        tablaModeloLibros.setRowCount(0);
        //Obtener los libros en la base de datos
        var libros = libroServicio.listarLibros();
        libros.forEach((libro)->{
            Object[] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            this.tablaModeloLibros.addRow(renglonLibro);
        });
    }
}
