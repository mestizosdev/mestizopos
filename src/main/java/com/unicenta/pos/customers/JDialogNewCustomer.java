package com.unicenta.pos.customers;

import com.unicenta.basic.BasicException;
import com.unicenta.data.gui.ComboBoxValModel;
import com.unicenta.data.gui.MessageInf;
import com.unicenta.data.loader.LocalRes;
import com.unicenta.data.loader.SentenceExec;
import com.unicenta.data.loader.SentenceList;
import com.unicenta.data.loader.TableDefinition;
import com.unicenta.format.Formats;
import com.unicenta.pos.forms.AppLocal;
import com.unicenta.pos.forms.AppView;
import com.unicenta.pos.forms.DataLogicSales;
import dev.mestizos.identification.Validator;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.util.List;
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JDialogNewCustomer extends javax.swing.JDialog {

    private DataLogicCustomers dlCustomer;
    private DataLogicSales dlSales;
    private ComboBoxValModel m_CategoryModel;
    private SentenceList m_sentcat;
    private SentenceExec m_sentinsert;
    private TableDefinition tcustomers;
    private CustomerInfoExt selectedCustomer;
    private Object m_oId;
    private SentenceList sentenceIdentificationType;
    private ComboBoxValModel modelIdentificationType;

    /**
     * Creates new form quick New Customer
     *
     * @param parent
     */
    protected JDialogNewCustomer(java.awt.Frame parent) {
        super(parent, true);
    }

    /**
     * Creates new form quick New Customer
     *
     * @param parent
     */
    protected JDialogNewCustomer(java.awt.Dialog parent) {
        super(parent, true);
    }

    private void init(AppView app) {

        try {
            dlSales = (DataLogicSales) app.getBean("com.unicenta.pos.forms.DataLogicSales");
            dlCustomer = (DataLogicCustomers) app.getBean("com.unicenta.pos.customers.DataLogicCustomers");
            m_sentcat = dlSales.getTaxCustCategoriesList();
            tcustomers = dlCustomer.getTableCustomers();
            sentenceIdentificationType = dlSales.getIdentificationTypeList();

            initComponents();

            m_CategoryModel = new ComboBoxValModel();
            List a = m_sentcat.list();
            a.add(0, null);

            m_CategoryModel = new ComboBoxValModel(a);
            m_jCategory.setModel(m_CategoryModel);

            modelIdentificationType = new ComboBoxValModel(
                    sentenceIdentificationType.list());
            cbxIdentificationType.setModel(modelIdentificationType);
            modelIdentificationType.setSelectedFirst();

            disableItems();

            getRootPane().setDefaultButton(m_jBtnOK);
        } catch (BasicException ex) {
        }
    }

    public Object createValue() throws BasicException {
        Object[] customer = new Object[28];
        customer[0] = m_oId;
        customer[1] = m_jTaxID.getText();//m_jSearchkey.getText();
        customer[2] = m_jTaxID.getText();
        customer[3] = m_jName.getText();
        customer[4] = m_CategoryModel.getSelectedKey();
        customer[5] = null;
        customer[6] = Formats.CURRENCY.parseValue(txtMaxdebt.getText(), 0.0);
        customer[7] = Formats.STRING.parseValue(txtAddress.getText());
        customer[8] = null;
        customer[9] = null;
        customer[10] = null;
        customer[11] = null;
        customer[12] = null;
        customer[13] = Formats.STRING.parseValue(txtFirstName.getText());
        customer[14] = Formats.STRING.parseValue(txtLastName.getText());
        customer[15] = Formats.STRING.parseValue(txtEmail.getText());
        customer[16] = Formats.STRING.parseValue(txtPhone.getText());
        customer[17] = Formats.STRING.parseValue(txtPhone2.getText());
        customer[18] = null;
        customer[19] = null;
        customer[20] = true;
        customer[21] = null;
        customer[22] = 0.0;
        customer[23] = null;
        customer[24] = m_jVip.isSelected();
        customer[25] = Formats.DOUBLE.parseValue(txtDiscount.getText());
        customer[26] = null;
        customer[27] = modelIdentificationType.getSelectedKey();

        return customer;
    }

    private void selectedVip(boolean value) {
        m_jVip.setSelected(value);
        jLblDiscountpercent.setVisible(value);
        txtDiscount.setVisible(value);

    }

    public static JDialogNewCustomer getDialog(Component parent, AppView app) {

        Window window = getWindow(parent);

        JDialogNewCustomer quicknewcustomer;

        if (window instanceof Frame) {
            quicknewcustomer = new JDialogNewCustomer((Frame) window);
        } else {
            quicknewcustomer = new JDialogNewCustomer((Dialog) window);
        }

        quicknewcustomer.init(app);

        return quicknewcustomer;
    }

    protected static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

    public CustomerInfoExt getSelectedCustomer() {
        return selectedCustomer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLblName = new javax.swing.JLabel();
        m_jName = new javax.swing.JTextField();
        jLblSearchkey = new javax.swing.JLabel();
        m_jSearchkey = new javax.swing.JTextField();
        jLblTaxID = new javax.swing.JLabel();
        m_jTaxID = new javax.swing.JTextField();
        jLblCustTaxCat = new javax.swing.JLabel();
        m_jCategory = new javax.swing.JComboBox();
        jLblVIP = new javax.swing.JLabel();
        m_jVip = new javax.swing.JCheckBox();
        jLblDiscount = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLblDiscountpercent = new javax.swing.JLabel();
        jLblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLblTelephone1 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLblTelephone2 = new javax.swing.JLabel();
        txtPhone2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMaxdebt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxIdentificationType = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        m_jBtnOK = new javax.swing.JButton();
        m_jBtnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("label.customer")); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 460));
        setResizable(false);

        jPanel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(655, 440));

        jLblName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblName.setText(AppLocal.getIntString("label.namem")); // NOI18N
        jLblName.setMaximumSize(new java.awt.Dimension(140, 25));
        jLblName.setMinimumSize(new java.awt.Dimension(140, 25));
        jLblName.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jName.setPreferredSize(new java.awt.Dimension(300, 30));
        m_jName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                m_jNameFocusGained(evt);
            }
        });

        jLblSearchkey.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblSearchkey.setText(AppLocal.getIntString("label.searchkeym")); // NOI18N
        jLblSearchkey.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jSearchkey.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jSearchkey.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        m_jSearchkey.setPreferredSize(new java.awt.Dimension(150, 30));

        jLblTaxID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblTaxID.setText(AppLocal.getIntString("label.taxid")); // NOI18N
        jLblTaxID.setMaximumSize(new java.awt.Dimension(150, 30));
        jLblTaxID.setMinimumSize(new java.awt.Dimension(140, 25));
        jLblTaxID.setPreferredSize(new java.awt.Dimension(100, 30));

        m_jTaxID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jTaxID.setPreferredSize(new java.awt.Dimension(100, 30));

        jLblCustTaxCat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblCustTaxCat.setText(AppLocal.getIntString("label.custtaxcategory")); // NOI18N
        jLblCustTaxCat.setMaximumSize(new java.awt.Dimension(140, 25));
        jLblCustTaxCat.setMinimumSize(new java.awt.Dimension(140, 25));
        jLblCustTaxCat.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jCategory.setPreferredSize(new java.awt.Dimension(0, 30));

        jLblVIP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblVIP.setText(AppLocal.getIntString("label.vip")); // NOI18N
        jLblVIP.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jVip.setForeground(new java.awt.Color(0, 188, 243));
        m_jVip.setPreferredSize(new java.awt.Dimension(21, 30));
        m_jVip.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                m_jVipnone(evt);
            }
        });

        jLblDiscount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblDiscount.setText(AppLocal.getIntString("label.discount")); // NOI18N
        jLblDiscount.setPreferredSize(new java.awt.Dimension(55, 30));

        txtDiscount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDiscount.setPreferredSize(new java.awt.Dimension(50, 30));

        jLblDiscountpercent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblDiscountpercent.setText("%");
        jLblDiscountpercent.setPreferredSize(new java.awt.Dimension(12, 30));

        jLblFirstName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblFirstName.setText(AppLocal.getIntString("label.firstname")); // NOI18N
        jLblFirstName.setAlignmentX(0.5F);
        jLblFirstName.setPreferredSize(new java.awt.Dimension(150, 30));

        txtFirstName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFirstName.setPreferredSize(new java.awt.Dimension(200, 30));

        jLblLastName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblLastName.setText(AppLocal.getIntString("label.lastname")); // NOI18N
        jLblLastName.setPreferredSize(new java.awt.Dimension(150, 30));

        txtLastName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLastName.setPreferredSize(new java.awt.Dimension(200, 30));

        jLblEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblEmail.setText(AppLocal.getIntString("label.email")); // NOI18N
        jLblEmail.setPreferredSize(new java.awt.Dimension(150, 30));

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(200, 30));

        jLblTelephone1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblTelephone1.setText(AppLocal.getIntString("label.phone")); // NOI18N
        jLblTelephone1.setPreferredSize(new java.awt.Dimension(150, 30));

        txtPhone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPhone.setPreferredSize(new java.awt.Dimension(200, 30));

        jLblTelephone2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblTelephone2.setText(AppLocal.getIntString("label.phone2")); // NOI18N
        jLblTelephone2.setPreferredSize(new java.awt.Dimension(150, 30));

        txtPhone2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPhone2.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText(AppLocal.getIntString("label.maxdebt")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(140, 25));
        jLabel1.setMinimumSize(new java.awt.Dimension(140, 25));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 30));

        txtMaxdebt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtMaxdebt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMaxdebt.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText(AppLocal.getIntString("label.identificationtype")); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(140, 25));
        jLabel11.setMinimumSize(new java.awt.Dimension(140, 25));
        jLabel11.setPreferredSize(new java.awt.Dimension(150, 30));

        cbxIdentificationType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText(AppLocal.getIntString("label.address")); // NOI18N
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 30));

        txtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAddress.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblTelephone1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblSearchkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLblTaxID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbxIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(m_jTaxID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLblCustTaxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(m_jCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLblTelephone2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPhone2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLblDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLblDiscountpercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(m_jVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLblVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(m_jSearchkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaxdebt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblSearchkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTaxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jTaxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jSearchkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxdebt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblTelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(m_jVip, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblDiscountpercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLblVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblCustTaxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(m_jCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblTelephone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);
        jPanel3.getAccessibleContext().setAccessibleName("");

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        m_jBtnOK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBtnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicenta/images/ok.png"))); // NOI18N
        m_jBtnOK.setText(AppLocal.getIntString("Button.OK")); // NOI18N
        m_jBtnOK.setFocusPainted(false);
        m_jBtnOK.setFocusable(false);
        m_jBtnOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnOK.setPreferredSize(new java.awt.Dimension(80, 45));
        m_jBtnOK.setRequestFocusEnabled(false);
        m_jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnOKActionPerformed(evt);
            }
        });
        jPanel2.add(m_jBtnOK);

        m_jBtnCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicenta/images/cancel.png"))); // NOI18N
        m_jBtnCancel.setText(AppLocal.getIntString("Button.Cancel")); // NOI18N
        m_jBtnCancel.setFocusPainted(false);
        m_jBtnCancel.setFocusable(false);
        m_jBtnCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnCancel.setPreferredSize(new java.awt.Dimension(80, 45));
        m_jBtnCancel.setRequestFocusEnabled(false);
        m_jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(m_jBtnCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(682, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnOKActionPerformed
        final var validator = new Validator();
        final var identificationType = (String) modelIdentificationType.getSelectedKey();
        final var identification = m_jTaxID.getText();

        final var error = validator.identification(identificationType, identification);
        if (error.getIsError()) {
            JOptionPane.showMessageDialog(
                    null,
                    error.getMessage(),
                    "Identificación Cliente",
                    JOptionPane.ERROR_MESSAGE);
        }
        else if ("".equals(m_jName.getText())) {
            JOptionPane.showMessageDialog(
                    null,
                    AppLocal.getIntString("message.customercheck"),
                    "Customer check",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                m_oId = UUID.randomUUID().toString();
                Object customer = createValue();

                int status = tcustomers.getInsertSentence().exec(customer);

                if (status > 0) {
                    selectedCustomer = dlSales.loadCustomerExt(m_oId.toString());
                    dispose();
                } else {
                    MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE,
                            LocalRes.getIntString("message.nosave"), "Error save");
                    msg.show(this);
                }

            } catch (BasicException ex) {
                MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE,
                        LocalRes.getIntString("message.nosave"), ex);
                msg.show(this);
            }
        }
    }//GEN-LAST:event_m_jBtnOKActionPerformed

    private void m_jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnCancelActionPerformed

        dispose();

    }//GEN-LAST:event_m_jBtnCancelActionPerformed

    private void disableItems() {
        jLblSearchkey.setVisible(false);
        m_jSearchkey.setVisible(false);
        jLabel1.setVisible(false);
        txtMaxdebt.setVisible(false);
        jLblDiscount.setVisible(false);
        txtDiscount.setVisible(false);
        jLblDiscount.setVisible(false);
        jLblVIP.setVisible(false);
        m_jVip.setVisible(false);
        jLblCustTaxCat.setVisible(false);
        m_jCategory.setVisible(false);
        jLblDiscountpercent.setVisible(false);
        jLblTelephone2.setVisible(false);
        txtPhone2.setVisible(false);
    }

private void m_jVipnone(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_m_jVipnone

}//GEN-LAST:event_m_jVipnone

    private void m_jNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_m_jNameFocusGained
        if (m_jName.getText().isEmpty()) {
            m_jName.setText(txtFirstName.getText() + " " + txtLastName.getText());
        }
    }//GEN-LAST:event_m_jNameFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxIdentificationType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLblCustTaxCat;
    private javax.swing.JLabel jLblDiscount;
    private javax.swing.JLabel jLblDiscountpercent;
    private javax.swing.JLabel jLblEmail;
    private javax.swing.JLabel jLblFirstName;
    private javax.swing.JLabel jLblLastName;
    private javax.swing.JLabel jLblName;
    private javax.swing.JLabel jLblSearchkey;
    private javax.swing.JLabel jLblTaxID;
    private javax.swing.JLabel jLblTelephone1;
    private javax.swing.JLabel jLblTelephone2;
    private javax.swing.JLabel jLblVIP;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton m_jBtnCancel;
    private javax.swing.JButton m_jBtnOK;
    private javax.swing.JComboBox m_jCategory;
    private javax.swing.JTextField m_jName;
    private javax.swing.JTextField m_jSearchkey;
    private javax.swing.JTextField m_jTaxID;
    private javax.swing.JCheckBox m_jVip;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMaxdebt;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhone2;
    // End of variables declaration//GEN-END:variables

}
