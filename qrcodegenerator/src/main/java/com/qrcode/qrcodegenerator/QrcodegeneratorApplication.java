package com.qrcode.qrcodegenerator;

import com.qrcode.qrcodegenerator.service.QRCodeGeneratorService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;;

import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class QrcodegeneratorApplication implements CommandLineRunner {

    @Autowired
    QRCodeGeneratorService qrCodeGeneratorService;

    public static void main(String[] args) {
        SpringApplication.run(QrcodegeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            //  prompt for the user's name
            log.info("Enter your message: ");

            // get their input as a String
            String inputMessage = scanner.nextLine();

            log.info("Input Message from console - {}", inputMessage);
            if (StringUtils.isNotBlank(inputMessage)) {
                qrCodeGeneratorService.generateQRCode(inputMessage);
            }
        }
    }
}
