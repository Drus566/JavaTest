import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestException;
import java.util.*;

public class Application extends JFrame {
    Application () {
        buildVer2();
    }

    public void buildVer1() {
        JFrame frame = this;
        JButton button;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Border Layout
        JPanel borderLayout = new JPanel(new BorderLayout());

        // Card Layout
        JPanel cardLayout = new JPanel(new CardLayout());

        JPanel firstLayout = new JPanel();
        firstLayout.add(new TextField("TThis is first layout"));

        JPanel secondLayout = new JPanel();
        secondLayout.add(new TextField("This is a second layout"));

        JPanel thirdLayout = new JPanel();
        thirdLayout.add(new TextField("This is a third layout"));

        JPanel settingsLayout = new JPanel();
        settingsLayout.add(new TextField("This is a settings layout"));
        settingsLayout.add(new JButton("Size"));
        settingsLayout.add(new JButton("Dimension"));
        settingsLayout.add(new JButton("Speed"));

        // Панель для кнопочек
        JPanel cardButtons = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.weightx = 0.0;

        JButton firstButton = new JButton("First Card");
        firstButton.setSize(new Dimension(50, 50));
        cardButtons.add(firstButton, constraints);

        constraints.gridy = 1;
        JButton secondButton = new JButton("Second Card");
        secondButton.setSize(new Dimension(50, 50));
        cardButtons.add(secondButton, constraints);

        constraints.gridy = 2;
        JButton thirdButton = new JButton("Third Card");
        thirdButton.setSize(new Dimension(50, 50));
        cardButtons.add(thirdButton, constraints);

        constraints.gridy = 100;
        constraints.anchor    = GridBagConstraints.PAGE_END;
        constraints.weighty   = 1.0;  // установить отступ
        constraints.ipady = 50;

        JButton settingsButton = new JButton("Settings");
        settingsButton.setSize(new Dimension(100, 100));
        cardButtons.add(settingsButton, constraints);

        cardButtons.setMinimumSize(new Dimension(300, 300));

        cardLayout.add(firstLayout,firstButton.toString());
        cardLayout.add(secondLayout,secondButton.toString());
        cardLayout.add(thirdLayout,thirdButton.toString());
        cardLayout.add(settingsLayout,settingsButton.toString());

        // Кладем кнопочки в бордер лайаут
        JScrollPane scroll = new JScrollPane(cardButtons);
        borderLayout.add(scroll, BorderLayout.WEST);
        borderLayout.add(cardLayout, BorderLayout.CENTER);

        frame.setContentPane(borderLayout);

        frame.pack();
        frame.setVisible(true);
    }

    public void buildVer2() {
        JFrame frame = this;
        JButton button;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Border Layout
        JPanel borderLayout = new JPanel(new BorderLayout());

        // Card Layout
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        JPanel firstLayout = new JPanel();
        createContent(firstLayout);

        JPanel secondLayout = new JPanel();
        secondLayout.add(new TextField("This is a second layout"));

        JPanel thirdLayout = new JPanel();
        thirdLayout.add(new TextField("This is a third layout"));

        JPanel settingsLayout = new JPanel();
        settingsLayout.add(new TextField("This is a settings layout"));
        settingsLayout.add(new JButton("Size"));
        settingsLayout.add(new JButton("Dimension"));
        settingsLayout.add(new JButton("Speed"));

        // Панель для кнопочек
        JPanel cardButtons = new JPanel();
        cardButtons.setLayout(new BoxLayout(cardButtons, BoxLayout.Y_AXIS));

        JButton mainButton = new JButton(".");
        mainButton.setMinimumSize(new Dimension(120,120));
        mainButton.setPreferredSize(new Dimension(120,120));
        mainButton.setMaximumSize(new Dimension(120,120));

        JButton topScrollButton = new JButton("Top Scroll");
        topScrollButton.setMinimumSize(new Dimension(96,46));
        topScrollButton.setPreferredSize(new Dimension(96,46));
        topScrollButton.setMaximumSize(new Dimension(96,46));

        JButton firstButton = new JButton("First Card");
        firstButton.setMinimumSize(new Dimension(96,96));
        firstButton.setPreferredSize(new Dimension(96,96));
        firstButton.setMaximumSize(new Dimension(96,96));

        JButton secondButton = new JButton("Second Card");
        secondButton.setMinimumSize(new Dimension(96,96));
        secondButton.setPreferredSize(new Dimension(96,96));
        secondButton.setMaximumSize(new Dimension(96,96));

        JButton thirdButton = new JButton("Third Card");
        thirdButton.setMinimumSize(new Dimension(96,96));
        thirdButton.setPreferredSize(new Dimension(96,96));
        thirdButton.setMaximumSize(new Dimension(96,96));

        JButton fourthButton = new JButton("Fourth Card");
        fourthButton.setMinimumSize(new Dimension(96,96));
        fourthButton.setPreferredSize(new Dimension(96,96));
        fourthButton.setMaximumSize(new Dimension(96,96));

        JButton fifthButton = new JButton("Fifth Card");
        fifthButton.setMinimumSize(new Dimension(96,96));
        fifthButton.setPreferredSize(new Dimension(96,96));
        fifthButton.setMaximumSize(new Dimension(96,96));

        JButton sixButton = new JButton("Six Card");
        sixButton.setMinimumSize(new Dimension(96,96));
        sixButton.setPreferredSize(new Dimension(96,96));
        sixButton.setMaximumSize(new Dimension(96,96));

        JButton seventhButton = new JButton("Seventh Card");
        seventhButton.setMinimumSize(new Dimension(96,96));
        seventhButton.setPreferredSize(new Dimension(96,96));
        seventhButton.setMaximumSize(new Dimension(96,96));

        JButton bottomScrollButton = new JButton("Bottom Scroll");
        bottomScrollButton.setMinimumSize(new Dimension(96,46));
        bottomScrollButton.setPreferredSize(new Dimension(96,46));
        bottomScrollButton.setMaximumSize(new Dimension(96,46));

        JButton settingsButton = new JButton("Settings");
        settingsButton.setMinimumSize(new Dimension(96,96));
        settingsButton.setPreferredSize(new Dimension(96,96));
        settingsButton.setMaximumSize(new Dimension(96,96));

        JPanel optButtonsPanel = new JPanel();
        optButtonsPanel.setLayout(new BoxLayout(optButtonsPanel, BoxLayout.Y_AXIS));
        optButtonsPanel.add(firstButton);
        optButtonsPanel.add(secondButton);
        optButtonsPanel.add(thirdButton);
        optButtonsPanel.add(fourthButton);
//        optButtonsPanel.add(fifthButton);
//        optButtonsPanel.add(sixButton);
//        optButtonsPanel.add(seventhButton);

        // ScrollBar
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            @Override
            public boolean isVisible() {
                return true;
            }
        };

        JScrollPane optButtonPanelScroll = new JScrollPane(optButtonsPanel);
        optButtonPanelScroll.setWheelScrollingEnabled(true);
        optButtonPanelScroll.setVerticalScrollBar(scrollBar);
        optButtonPanelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        optButtonPanelScroll.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
//                System.out.println("SIZE " + optButtonPanelScroll.getSize());
//                System.out.println("EXTENT SIZE " + optButtonPanelScroll.getViewport().getExtentSize());
//                System.out.println("VIEW SIZE " + optButtonPanelScroll.getViewport().getViewSize());

                Dimension viewSize = optButtonPanelScroll.getViewport().getViewSize();
                Dimension extentSize = optButtonPanelScroll.getViewport().getExtentSize();

                if (extentSize.height < viewSize.height) {
                    if (!topScrollButton.isVisible()) {
                        topScrollButton.setVisible(true);
                    }
                    if (!bottomScrollButton.isVisible()) {
                        bottomScrollButton.setVisible(true);
                    }
                } else {
                    if (topScrollButton.isVisible()) {
                        topScrollButton.setVisible(false);
                    }
                    if (bottomScrollButton.isVisible()) {
                        bottomScrollButton.setVisible(false);
                    }
                }
            }
        });

        //optButtonPanelScroll.getViewport().

        //optButtonPanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        bottomScrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point viewOrigin = optButtonPanelScroll.getViewport().getViewPosition();

                //if (viewOrigin.y < 7000) {
                    viewOrigin.y = viewOrigin.y + 96;
                //}

                optButtonPanelScroll.getViewport().setViewPosition(viewOrigin);
            }
        });

        topScrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point viewOrigin = optButtonPanelScroll.getViewport().getViewPosition();

                if (viewOrigin.y > 0) {
                    viewOrigin.y = viewOrigin.y - 96;
                }

                optButtonPanelScroll.getViewport().setViewPosition(viewOrigin);
            }
        });

        cardButtons.add(mainButton);
        cardButtons.add(topScrollButton);
        cardButtons.add(optButtonPanelScroll);
        cardButtons.add(bottomScrollButton);
        cardButtons.add(Box.createVerticalGlue());
        cardButtons.add(settingsButton);

        //bottomScrollButton.setVisible(false);
        //topScrollButton.setVisible(false);

        //cardButtons.setPreferredSize(new Dimension(300, 300));
        cardButtons.setBackground(Color.RED);

        cardPanel.add(firstLayout,"first");
        cardPanel.add(secondLayout,"second");
        cardPanel.add(thirdLayout,"third");
        cardPanel.add(settingsLayout,"settings");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "first");
            }
        });
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "second");
            }
        });
        thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "third");
            }
        });

        System.out.println(thirdButton.toString());

        // Кладем кнопочки в бордер лайаут
        borderLayout.add(cardButtons, BorderLayout.WEST);
        borderLayout.add(cardPanel, BorderLayout.CENTER);

        frame.setContentPane(borderLayout);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Application app = new Application();
    }

    public void createContent(JPanel panel) {

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;

        JTable table;
        //panel.add(new TextField("TThis is first layout"));
        panel.setBackground(Color.GREEN);

        String[] columnNames = {"Name", "Roll Number", "Department"};
        String[][] data = getData();
        table = new JTable(data, columnNames);
        //table.setPreferredSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));

        //table.setMinimumSize(new Dimension(100,100));
        JScrollPane sp = new JScrollPane(table);
        //sp.setMinimumSize(new Dimension(100,100));

        //panel.add(sp, c);

        JTable table1;
        table1 = new JTable(data,columnNames);
        JScrollPane sp1 = new JScrollPane(table1);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.RELATIVE;

        //panel.add(sp1, c);

        JTable table2;
        table2 = new JTable(data,columnNames);
        JScrollPane sp2 = new JScrollPane(table2);

        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 3;
        c.gridy = 0;
        c.ipady = 10;
        c.ipadx = 20;

        //panel.add(sp2, c);

        JTable table3;
        table3 = new JTable(data,columnNames);
        JScrollPane sp3 = new JScrollPane(table3);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;

        // panel.add(sp3, c);

        JTable table4;
        table4 = new JTable(data,columnNames);
        JScrollPane sp4 = new JScrollPane(table4);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 1;

        // panel.add(sp4, c);

        JTable table5;
        table5 = new JTable(data,columnNames);
        JScrollPane sp5 = new JScrollPane(table5);
        table5.setBackground(Color.BLACK);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;

        // panel.add(sp5, c);

        JTable table6;
        table6 = new JTable(data,columnNames);
        setTextArea(table6);

        JScrollPane sp6 = new JScrollPane(table6);
        table6.setBackground(Color.YELLOW);
        table6.setRowSelectionAllowed(false);
        table6.setCellSelectionEnabled(false);
        table6.setFocusable(false);
        table6.setDefaultEditor(Object.class, null);
        table6.getTableHeader().setResizingAllowed(false);

        table6.setShowGrid(false);
        table6.getTableHeader().setReorderingAllowed(false);
        TableColumn column1 = table6.getColumnModel().getColumn(0);
        column1.setPreferredWidth(600);
//        column.setMinWidth(500);
        column1.setMaxWidth(Short.MAX_VALUE);
        DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();
        render1.setHorizontalAlignment(JLabel.LEFT);
        column1.setCellRenderer(render1);

        TableColumn column2 = table6.getColumnModel().getColumn(1);
        column2.setPreferredWidth(300);
//        column.setMinWidth(500);
        column2.setMaxWidth(Short.MAX_VALUE);
        DefaultTableCellRenderer render2 = new DefaultTableCellRenderer();
        render2.setHorizontalAlignment(JLabel.CENTER);
        column2.setCellRenderer(render2);

        TableColumn column3 = table6.getColumnModel().getColumn(2);
        column3.setPreferredWidth(300);
//        column.setMinWidth(500);
        column3.setMaxWidth(Short.MAX_VALUE);
        DefaultTableCellRenderer render3 = new DefaultTableCellRenderer();
        render3.setHorizontalAlignment(JLabel.CENTER);
        column3.setCellRenderer(render3);

        table6.setFont(loadFont());
        table6.setRowHeight(30);
        table6.getTableHeader().setFont(loadFont());
        table6.getTableHeader().setPreferredSize(new Dimension(table6.getColumnModel().getTotalColumnWidth(), 100));


        UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));


        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        //c.gridheight = 2;

        c.fill = GridBagConstraints.BOTH;
        //c.insets = new Insets(0, 0, 0, 200);



        // положение относительно центра
        // c.anchor = GridBagConstraints.PAGE_END;
        // нестандартная высота и ширина ячейки
//        c.ipady = 300;
//        c.ipadx = 400;

        panel.add(sp6, c);

        JPanel tableWithTitle = new JPanel();
        JLabel title = new JLabel("Свой титульник", SwingConstants.CENTER);
        Font f = loadFont();
        title.setFont(f);
        JTable table7 = new JTable(data, columnNames);
        JScrollPane sp7 = new JScrollPane(table7);
        table7.setBackground(Color.YELLOW);
        table7.setTableHeader(null);
//        table7.getTableHeader().setUI(null);
        tableWithTitle.setLayout(new BorderLayout());
        tableWithTitle.add(title, BorderLayout.NORTH);
        tableWithTitle.add(sp7, BorderLayout.CENTER);


        //c.insets = new Insets(10, 10, 10, 10);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        //panel.add(tableWithTitle, c);

    }

    private String[][] getData() {
        String[][] data = {
                {"<html>EMS<br>Priority<br>Document" ,"4031", "CSE" },
                {"Anand Jhaasdddddddddddasddddddddddddddddd", "6014", "IT"},
                {"Anand Jha", "6014", "IasddddddddddddddT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IsaddddddddddddT"},
                {"Anand Jha", "6asddddddddddd014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"},
                {"Anand Jha", "6014", "IT"}
        };
        return data;
    }

    private Font loadFont() {
        Font f = null;
        try {
            f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("./resources/onest.ttf"))).deriveFont(Font.PLAIN, 12);
            //f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("./resources/FontinSans_Cyrillic_46b/FontinSans_Cyrillic_B_46b.otf"))).deriveFont(Font.PLAIN, 24);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    private void setThemeUI() {
        try {
            //UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }

    private void setTextArea(JTable table) {

        TableColumnModel columnModel = table.getColumnModel();
        Dimension tableHeaderSize = table.getTableHeader().getPreferredSize();

        int countColumns = columnModel.getColumnCount();
        int countRows = table.getRowCount();

        ArrayList<String> tableColumnNames = new ArrayList<>(0);
        ArrayList<ArrayList<String>> tableRowNames = new ArrayList<>(0);

        for (int e = 0; e < countRows; e++) {
            ArrayList<String> arrNames = new ArrayList<>(0);
            for (int k = 0; k < countColumns; k++) {
                arrNames.add(table.getValueAt(e, k).toString());
            }
            tableRowNames.add(arrNames);
        }

        for (int i = 0; i < countColumns; i++) {
            tableColumnNames.add(table.getColumnName(i));
        }

        //table.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        for (int i = 0; i < countColumns; i++) {
            table.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(new MultiLineTableHeaderRenderer());
            table.getColumnModel().getColumn(i).setCellRenderer(new MultiLineTableHeaderRenderer());
        }
//        table



        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        FontMetrics fm = img.getGraphics().getFontMetrics(loadFont());

        ArrayList<Integer> widthColumns = new ArrayList<Integer>(0);
        for (String title : tableColumnNames) {
            widthColumns.add(fm.stringWidth(title) + 5);
        }

        HashMap<Integer, ArrayList<Integer>> rowNameWidthMap = new HashMap<Integer, ArrayList<Integer>>(0);

        int rowCounter = 0;
        for (ArrayList<String> arList : tableRowNames) {
            ArrayList<Integer> tempMap = new ArrayList<Integer>(0);
            int max = 0;
            int index = 0;
            int i = 0;
            for (String name : arList) {
                int width = fm.stringWidth(name) + 5;
                if (max < width) {
                    max = width;
                    index = i;
                }
                i++;
            }
            tempMap.add(index);
            tempMap.add(max);

            rowNameWidthMap.put(rowCounter, tempMap);
            rowCounter++;
        }

        int prefferedSizesRows[] = new int[countRows];
        for (int i = 0 ; i < countRows; i++) {
            prefferedSizesRows[i] = table.getRowHeight(i);
        }


        columnModel.addColumnModelListener(new TableColumnModelListener()
        {
            @Override
            public void columnAdded(TableColumnModelEvent arg0) {
//                System.out.println ("TableColumnModelListener.columnAdded()");
            }
            @Override
            public void columnMarginChanged(ChangeEvent arg0) {
//                System.out.println ("TableColumnModelListener.columnMarginChanged()");
//                System.out.println(columnModel.getColumn(0).getWidth());
//                System.out.println((x * (fontSize - 6)) - fontSize * 0.1));
//                double k = fontSize * 0.535;
//                double i = fontSize / 3;
//                long width = Math.round(x * k + i);
//                System.out.println(width);
//                table1.getTableHeader().getColumnModel().getColumn(0).getHeaderValue();

                for (int i = 0; i < countColumns; i++) {
                    if (columnModel.getColumn(i).getWidth() < widthColumns.get(i)) {
                        table.getTableHeader().setPreferredSize(new Dimension(tableHeaderSize.width, tableHeaderSize.height * 2));
                    } else {
                        table.getTableHeader().setPreferredSize(tableHeaderSize);
                    }
                  //  System.out.println(width);
                }


                ArrayList<Integer> arr1 = rowNameWidthMap.get(0);
                System.out.println(columnModel.getColumn(arr1.get(0)).getWidth());
                System.out.println(arr1.get(1));


                for (int j = 0; j < countRows; j++) {
                    ArrayList<Integer> arr = rowNameWidthMap.get(j);


                    if (columnModel.getColumn(arr.get(0)).getWidth() < arr.get(1)) {
                        //rowNames.getKey()
                        table.setRowHeight(prefferedSizesRows[j] * 2);
                    } else {
                        table.setRowHeight(prefferedSizesRows[j]);
                    }
                }
            }
            @Override
            public void columnMoved(TableColumnModelEvent arg0) {
//                System.out.println ("TableColumnModelListener.columnMoved()");
            }
            @Override
            public void columnRemoved(TableColumnModelEvent arg0) {}
            @Override
            public void columnSelectionChanged(ListSelectionEvent arg0) {
//                System.out.println ("TableColumnModelListener.columnSelectionChanged()");
            }
        });
    }

    class TextAreaRenderer extends JTextArea
            implements TableCellRenderer {

        public TextAreaRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getTableCellRendererComponent(JTable jTable,
                                                       Object obj, boolean isSelected, boolean hasFocus, int row,
                                                       int column) {
            setText((String)obj);
            return this;
        }
    }

    class MultiLineTableHeaderRenderer extends JTextArea implements TableCellRenderer
    {
        public MultiLineTableHeaderRenderer() {
            setEditable(false);
            setLineWrap(true);
            setOpaque(false);
            setFocusable(false);
            setWrapStyleWord(true);
            //LookAndFeel.installBorder(this, "TableHeader.cellBorder");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            int width = table.getColumnModel().getColumn(column).getWidth();
            setText((String)value);
            setSize(width, getPreferredSize().height);
            return this;
        }
    }
}

class TextParser {

}