package com.qrcode.qrcodegenerator.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrcode.qrcodegenerator.dto.ProductDTO;
import com.qrcode.qrcodegenerator.model.Product;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
public class QRCodeGenerator {

    public static void generateQRCode(ProductDTO dto) throws WriterException, IOException {
        //String qrCodePath = "C:\\blog-posts\\QRCode\\";
        String qrCodePath = "/home/thales/Documents/QRCode/";
        String qrCodeName = qrCodePath+ dto.getProductName()+dto.getId()+"-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(
                "Cod.: "+ dto.getCode()+ "\n"+
                        "Produto: "+ dto.getProductName()+ "\n"+
                        "Quantidade: "+ dto.getAmount()+ "\n"+
                        "Preço: "+ dto.getPrice()+ "\n" +
                        "Lote: "+ dto.getBatch()+ "\n" +
                        "Descrição: "+ dto.getDescription(), BarcodeFormat.QR_CODE, 400, 400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
