/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Pedido;

import DAO.PedidoDAO;
import DAO.ClienteDAO;
import javax.swing.JOptionPane;
import DAO.ProdutoDAO;
import Model.PedidoModel;
import Model.ClienteModel;
import Model.ItemPedidoModel;
import Model.ProdutoModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author forster
 */
public class FrmCadastrarPedido extends javax.swing.JFrame {

    private PedidoModel pedidoModel;
    private Double total = 0.00;
   
    /**
     * Creates new form FrmCadastrarEndereco
     */
    public FrmCadastrarPedido() {
        initComponents();
        
        String[] sourceClienteComboBox = new ClienteDAO().GetAllComboBox();
        
        for(var cliente : sourceClienteComboBox){
            comboBoxCliente.addItem(cliente);
            
        }
        
        
        pedidoModel = new PedidoModel();
        
        if(pedidoModel.getProdutos().isEmpty()){
            jButton3.setEnabled(false);
        }
    }
    
    public void populateTable(){
        
        String[][] data = new PedidoDAO().GetProdutoByPedidoId(pedidoModel);
        String[] colunas = new String[]{"Produto","Valor Unitário","Quantidade","Valor Total"};
        
        DefaultTableModel tableModel = new DefaultTableModel(data, colunas);
        
        jTable2.setModel(tableModel);
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPedidoProdutos = new javax.swing.JList<>();
        comboBoxCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        fieldPedidoQuantidade = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        fieldValorTotal = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Realizar Pedido");

        jLabel2.setText("Cliente");

        jLabel3.setText("Produto");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Incluir produto");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        listaPedidoProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPedidoProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaPedidoProdutos);

        comboBoxCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboBoxClienteFocusLost(evt);
            }
        });
        comboBoxCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comboBoxClienteMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboBoxClienteMouseReleased(evt);
            }
        });

        jLabel4.setText("Quantidade");

        jButton3.setText("Finalizar Pedido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        fieldPedidoQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        fieldPedidoQuantidade.setEnabled(false);

        jLabel5.setText("Total");

        fieldValorTotal.setEditable(false);
        fieldValorTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        fieldValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldValorTotalActionPerformed(evt);
            }
        });

        jButton4.setText("Criar Pedido");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Valor Unitário", "Quantidade", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jButton5.setText("Excluir produto");
        jButton5.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(fieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldPedidoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(fieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(fieldPedidoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jButton5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
    
    String[] produto = listaPedidoProdutos.getSelectedValue().split(" - ");
    
    ProdutoModel produtoModel = new ProdutoModel(
            produto[1], 
            Double.parseDouble(produto[2].replace("Valor Unitário: R$ ", "")), 
            produto[3].replace("Qtde Estoque: ",""));
    
    produtoModel.setId(Integer.parseInt(produto[0]));
    
    ItemPedidoModel itemPedidoModel = new ItemPedidoModel(
            produtoModel, 
            Integer.parseInt(fieldPedidoQuantidade.getValue().toString()), 
            pedidoModel);
    
    pedidoModel.getProdutos().add(itemPedidoModel);
    
    if(!jButton3.isEnabled()){
        jButton3.setEnabled(true);
    }
    
    jButton5.setEnabled(true);
    
    this.total += itemPedidoModel.getValorTotal();
    
    fieldValorTotal.setText("R$ " + String.format("%.2f", total));
    
    populateTable();
    
    JOptionPane.showMessageDialog(null, "Produto inserido no pedido. \nValor Total: R$ " + itemPedidoModel.getValorTotal(), "SUCESSO", 2);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listaPedidoProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPedidoProdutosMouseClicked
      
    }//GEN-LAST:event_listaPedidoProdutosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // finalizar pedido
        
        this.dispose();
        
        new FrmFinalizarPedido(pedidoModel).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboBoxClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxClienteMouseExited
        //comboBoxFornecedor.setEnabled(false);
    }//GEN-LAST:event_comboBoxClienteMouseExited

    private void comboBoxClienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxClienteMouseReleased
        //comboBoxFornecedor.setEnabled(false);
    }//GEN-LAST:event_comboBoxClienteMouseReleased

    private void comboBoxClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxClienteFocusLost
        comboBoxCliente.setEnabled(false);
    }//GEN-LAST:event_comboBoxClienteFocusLost

    private void fieldValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldValorTotalActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String[] sourceListaCompraProdutos = new ProdutoDAO().GetAllJList();
        
        listaPedidoProdutos.setListData(sourceListaCompraProdutos);
        
        jButton2.setEnabled(true);
        
        fieldPedidoQuantidade.setEnabled(true);
        
        if(pedidoModel.getCliente()== null){
        
        String[] cliente = comboBoxCliente.getSelectedItem().toString().split(" - ");
    
        ClienteModel clienteModel = new ClienteModel(cliente[1], null, cliente[2], null, null);
        
        clienteModel.setId(Integer.parseInt(cliente[0]));
        
        pedidoModel.setCliente(clienteModel);
        
        }
        
        this.pedidoModel.setId(new PedidoDAO().abrirPedido(pedidoModel));
        
        jButton4.setEnabled(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxCliente;
    private javax.swing.JSpinner fieldPedidoQuantidade;
    private javax.swing.JTextField fieldValorTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JList<String> listaPedidoProdutos;
    // End of variables declaration//GEN-END:variables
}
