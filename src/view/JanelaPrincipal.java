/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.MouseListener;

/**
 *
 * @author caique
 */
public class JanelaPrincipal extends JFrame{
    static int q=0;
    private JButton btnAdd,btnRmv,btnAlter,btnList;
    private JLabel titulo;
    private JPanel pnlAdd,pnlRmv,pnlAlter,pnlList,pnlMenu,janela;
    private CardLayout cl;
    
    public JanelaPrincipal(){
        super("Livraria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        cl = new CardLayout();
        janela = new JPanel();
        janela.setLayout(cl);
        
        titulo = new JLabel("Livraria");
        pnlAdd = new JPanel();
        pnlAlter = new JPanel();
        pnlRmv = new JPanel();
        pnlList = new JPanel();
        pnlMenu = new JPanel();
        btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new PaginaAdd());
        btnAdd.addMouseListener(new ContadorBtn());
        btnRmv = new JButton("Remover");
        btnRmv.addActionListener(new PaginaRmv());
        btnRmv.addMouseListener(new ContadorBtn());
        btnAlter = new JButton("Alterar");
        btnAlter.addActionListener(new PaginaAlter());
        btnList = new JButton("Buscar");
        btnList.addActionListener(new PaginaList());
        pnlMenu.setLayout(new GridLayout(1,4));
        pnlMenu.add(btnAdd);
        pnlMenu.add(btnList);
        pnlMenu.add(btnAlter);
        pnlMenu.add(btnRmv);
        janela.add(pnlAdd);
        janela.add(pnlList);
        janela.add(pnlAlter);
        janela.add(pnlRmv);
        setLayout(new BorderLayout());
        add(janela, BorderLayout.CENTER);
        add(pnlMenu, BorderLayout.NORTH);
        setSize(300, 500);
        
    }
    
    private class PaginaAdd implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("a");
            cl.show(janela, "Adicionar");            
        }

    }
    
    private class PaginaAlter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("b");
            cl.show(janela, "Alterar");
        }
        
    }

    private class PaginaList implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("c"); 
            cl.show(janela, "Listar");            
        }
        
    }    
    
    private class PaginaRmv implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("d");
            cl.show(janela, "Remover");        
        }
        
    }
    
    private class ContadorBtn extends MouseAdapter{

        
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getClickCount());
            System.out.println("botao clicado " + ++q + " vezes");
        }

    }
    
}
