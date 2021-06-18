package View;

import Controller.ControllerBook;
import Controller.ControllerFile;
import Model.Book;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ViewBook extends javax.swing.JFrame {

    ControllerBook controllerBook = new ControllerBook();
    ControllerFile controllerFile = new ControllerFile();
    private ArrayList<Book> data;
    private Book book = new Book();
    private int index;
    private String picturePath = "";
    private String imagesPath = "images";
    private String bookFilePath = "BooksList.txt";

    public ViewBook(ArrayList<Book> list) {
        initComponents();
        setLocationRelativeTo(null);
        this.data = list;
        btnDelete.setVisible(false);
        ComboboxFill();
        txtBookId.setText(String.valueOf(data.size() + 1));

    }

    public void ComboboxSelect(float rating) {
        for (int i = 0; i < cbRating.getItemCount(); i++) {
            if (rating == Float.parseFloat(cbRating.getItemAt(i))) {
                cbRating.setSelectedIndex(i);
                return;
            }
        }
    }

    public void SetPicture(String path) {
        jPicture.setIcon(new ImageIcon(
                new ImageIcon(path).getImage().getScaledInstance(200, 280, Image.SCALE_AREA_AVERAGING)));
        picturePath = path;
    }

    public void ComboboxFill() {
        cbRating.removeAllItems();
        for (float i = 1; i <= 5.1; i += 0.1) {
            cbRating.addItem(Float.toString(i).substring(0, 3));
        }
    }

    public ViewBook(ArrayList<Book> list, Book _book) {
        initComponents();
        setLocationRelativeTo(null);
        ComboboxFill();

        btnAdd.setText("Update");
        this.data = list;

        this.book = controllerBook.Get(list, _book.getBookId());

        txtBookId.setText(String.valueOf(book.getBookId()));
        txtTitle.setText(book.getTitle());
        txtCategory.setText(book.getCategory());
        txtAuthor.setText(book.getAuthor());
        txtAward.setText(book.getAward());
        ComboboxSelect(book.getRating());
        txtYear.setText(String.valueOf(book.getYear()));
        txtPages.setText(String.valueOf(book.getNumberOfPages()));
        txtDescription.setText(String.valueOf(book.getShortDescription()));

        SetPicture(imagesPath + "/" + String.valueOf(book.getBookId()) + ".jpg");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBookId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtAward = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPages = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnImageSelect = new javax.swing.JButton();
        jPicture = new javax.swing.JLabel();
        cbRating = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Book");
        setResizable(false);

        jLabel1.setText("Book Id");

        txtBookId.setEnabled(false);

        jLabel2.setText("Title");

        jLabel3.setText("Category");

        jLabel4.setText("Author");

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("Award Winner");

        jLabel6.setText("Rating");

        jLabel7.setText("Year");

        jLabel8.setText("Number of Pages");

        jLabel9.setText("Short Description");

        btnImageSelect.setText("IMAGE SELECT");
        btnImageSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageSelectActionPerformed(evt);
            }
        });

        jPicture.setPreferredSize(new java.awt.Dimension(200, 100));

        cbRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "4", "3", "2", "1" }));

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnImageSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtYear)
                                    .addComponent(txtBookId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTitle)
                                    .addComponent(txtCategory)
                                    .addComponent(txtAuthor)
                                    .addComponent(txtAward)
                                    .addComponent(cbRating, 0, 187, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPages, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(6, 6, 6)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4))
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5))
                            .addComponent(txtAward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel7))
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addComponent(btnImageSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (controllerBook.Delete(data, book)) {
            JOptionPane.showMessageDialog(null, "Deleted.");
            controllerFile.WriteData(data, bookFilePath);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Operation Failed.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        book.setTitle(txtTitle.getText());
        book.setCategory(txtCategory.getText());
        book.setAuthor(txtAuthor.getText());
        book.setAward(txtAward.getText());
        book.setRating(Float.parseFloat(cbRating.getSelectedItem().toString()));
        book.setYear(Integer.parseInt(txtYear.getText()));
        book.setNumberOfPages(Integer.parseInt(txtPages.getText()));
        book.setShortDescription(txtDescription.getText());

        if (btnAdd.getText().equals("Update")) {

            if (controllerBook.Update(data, book)) {
                try {
                    Files.copy(new File(picturePath).toPath(),
                            new File(imagesPath + "/" + String.valueOf(book.getBookId()) + ".jpg").toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "Updated.");
                } catch (IOException ex) {
                    Logger.getLogger(ViewBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operation Failed.");
            }
        } else {
            if (picturePath.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill in the required fields!");
                return;
            }
            if (controllerBook.Add(data, book)) {
                try {
                    int newId = controllerBook.NewId(data) - 1;
                    Files.copy(new File(picturePath).toPath(),
                            new File(imagesPath + "/" + String.valueOf(newId) + ".jpg").toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "Added.");
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(ViewBook.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Operation Failed.");
            }
        }
        controllerFile.WriteData(data, bookFilePath);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnImageSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageSelectActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Book Picture Select");
        int returnVal = chooser.showOpenDialog(this);

        if (returnVal == 0) {
            File file = chooser.getSelectedFile();
            picturePath = file.getAbsolutePath();
            SetPicture(picturePath);
        }

    }//GEN-LAST:event_btnImageSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnImageSelect;
    private javax.swing.JComboBox<String> cbRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jPicture;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtAward;
    private javax.swing.JTextField txtBookId;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtPages;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
