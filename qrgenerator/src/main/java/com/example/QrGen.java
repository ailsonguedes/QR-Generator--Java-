package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrGen {
    public static void main(String[] args) throws WriterException, IOException {

        Scanner ln = new  Scanner(System.in);
        String text;

        System.out.print("Digite o link: ");
        text = ln.nextLine();
        
        int width = 300;
        int height = 300;

        // Cria o objeto QRCodeWriter
        QRCodeWriter writer = new QRCodeWriter();

        // Cria a matriz de bits para o QR Code
        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);

        // salvando o QR code em um arquivo PNG
        File qrFile = new File("qrcode.png");
        MatrixToImageWriter.writeToFile(bitMatrix, "PNG", qrFile);
    }
}

