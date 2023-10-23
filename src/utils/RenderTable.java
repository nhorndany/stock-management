package utils;

import model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;

public class RenderTable {

    public static void renderProducts(List<Product> productList) {
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER,
                ShownBorders.SURROUND_HEADER_AND_COLUMNS);

        // render menu
        List<String> productMenu = new ArrayList<>(List.of("ID", "Name", "Unit Price", "QTY", "Date"));
        table.setColumnWidth(0, 10, 20);
        table.setColumnWidth(1, 19, 20);
        table.setColumnWidth(2, 19, 20);
        table.setColumnWidth(3, 19, 20);
        table.setColumnWidth(4, 19, 20);
        for (String menu : productMenu) {
            table.addCell(menu, cellStyle);
        }

        for (Product product : productList) {
            table.addCell(product.getId() + "", cellStyle);
            table.addCell(product.getProName(), cellStyle);
            table.addCell(product.getUnitPrice() + "", cellStyle);
            table.addCell(product.getQty() + "", cellStyle);
            table.addCell(product.getLocalDate() + "", cellStyle);
        }

        System.out.println(table.render());

    }

    public static void renderMenuList() {

        List<String> menuList = new ArrayList<>(List.of
                (
                        "*/Display", "W/rite", "R/read", "U/pdate", "D/elete", "F/ist",
                        "P/revious", "N/ext", "L/ast", "S/earch", "G/oto", "Se/t row", "H/elp", "E/xit"
                )
        );

        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table menuTable = new Table(8, BorderStyle.UNICODE_BOX_DOUBLE_BORDER,
                ShownBorders.SURROUND);

        menuTable.setColumnWidth(0, 12, 15);
        menuTable.setColumnWidth(1, 12, 15);
        menuTable.setColumnWidth(2, 12, 15);
        menuTable.setColumnWidth(3, 12, 15);
        menuTable.setColumnWidth(5, 12, 15);
        menuTable.setColumnWidth(4, 12, 15);
        menuTable.setColumnWidth(6, 12, 15);
        menuTable.setColumnWidth(7, 10, 15);


        for (String menu : menuList) {
            menuTable.addCell(menu, cellStyle);
        }

        System.out.println(menuTable.render());
    }

    public static void systemHeader() {
        System.out.println();
        System.out.println("""
                 ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗    \s
                ██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗   \s
                ██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║   \s
                ██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║   \s
                ╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║   \s
                 ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝                                                                                                                                  \s
                """);
        System.out.println("STOCK MANAGEMENT SYSTEM");
        System.out.println();
    }

    public static void readTable(List<Product> productList) {

        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table readTable = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER,
                ShownBorders.SURROUND);

        readTable.setColumnWidth(0, 20, 15);


        List<String> readList = new ArrayList<>(List.of
                (
                        "Product ID :", "Product Name : ", "Unit Price : ", "Quantity : ", "Imported Date : "
                )
        );

        for (String read : readList) {
            readTable.addCell(read);
        }

        for (Product product : productList) {
            readTable.addCell(product.getId() + "");
            readTable.addCell(product.getProName());
            readTable.addCell(product.getUnitPrice() + "");
            readTable.addCell(product.getQty() + "");
            readTable.addCell(product.getLocalDate() + "");
        }

        System.out.println(readTable.render());
    }

    public static void updateTable() {

        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table updateTable = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER,
                ShownBorders.SURROUND);

        updateTable.setColumnWidth(0, 20, 15);
        updateTable.setColumnWidth(1, 20, 15);
        updateTable.setColumnWidth(2, 20, 15);
        updateTable.setColumnWidth(3, 20, 15);
        updateTable.setColumnWidth(4, 20, 15);

        List<String> updateList = new ArrayList<>(List.of("1. All", "2. Name", "3. Unit Price"
                , "4. Quantity", "5. Back to Menu"));

        for (String update : updateList) {
            updateTable.addCell(update);
        }

        System.out.println(updateTable.render());

    }
}

