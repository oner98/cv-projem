package com.alioner.portfolio.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    @GetMapping("/profile")
    public ProfileResponse profile() {
        return new ProfileResponse(
                "Ali Öner Filibeli",
                "Yönetim Bilişim Sistemleri Uzmanı & Developer",
                "filibelialioner@gmail.com",
                "+90 530 112 9841",
                "Karamürsel, Kocaeli, Türkiye",
                "https://github.com/oner98",
                "https://linkedin.com/in/ali-öner-filibeli-5086b82b8",
                List.of("Java", "Python", "C#", "Kotlin", "Spring Boot", ".NET Core",
                        "MySQL", "PostgreSQL", "AWS", "Azure", "Docker", "Kubernetes",
                        "İngilizce (C1)", "Almanca"));
    }

    @GetMapping("/projects")
    public List<ProjectResponse> projects() {
        return List.of(
                new ProjectResponse("Event Planner Microservices",
                        List.of("Java 17", "Spring Boot", "Spring Cloud", "Maven"),
                        "Etkinlik, rezervasyon ve ödeme servislerini içeren çok modüllü backend çalışması.",
                        "https://github.com/oner98/eventplanner/tree/main/eventplanner-main/eventplanner_parent_linked/eventplanner3"),
                new ProjectResponse("Python Yardımcı Uygulaması",
                        List.of("Python", "Tkinter GUI", "Text Processing", "CSV", "JSON"),
                        "Sohbet, metin analizi ve istatistikleri ile dosya işlemlerini bir araya getiren masaüstü yardımcı uygulaması.",
                        "https://github.com/oner98/ai-Project"),
                new ProjectResponse("gRPC İstemci-Sunucu Laboratuvarı",
                        List.of("Java", "gRPC", "Protocol Buffers", "Maven"),
                        "Protocol Buffers ile tanımlanan Greeter servisi üzerinden gRPC istemci-sunucu iletişimini gösteren öğrenme çalışması.",
                        "https://github.com/oner98/grpc-server"),
                new ProjectResponse("Film Satın Alma ve Kiralama Sistemi",
                        List.of("Java", "OOP", "Inheritance", "Collections"),
                        "Film kataloğu, kullanıcı kredisi, satın alma ve abonelik üzerinden kiralama akışlarını nesne yönelimli sınıflarla modelleyen konsol çalışması.",
                        "https://github.com/oner98/film-sistemi"),
                new ProjectResponse("Alışveriş Sitesi Arayüzü",
                        List.of("HTML", "CSS", "Responsive Layout"),
                        "Ürün kartları, görselleri ve kullanıcı bilgi formu içeren statik web arayüzü çalışması.",
                        "https://github.com/oner98/Javascript-example/blob/main/al%C4%B1%C5%9Fveri%C5%9F%20sitesi.html"),
                new ProjectResponse("Windows Forms Çarpım Tablosu",
                        List.of("C#", "Windows Forms", "Input Validation"),
                        "Kullanıcının başlangıç, bitiş ve çarpan değerlerini girerek aralık için çarpım tablosu oluşturduğu masaüstü uygulaması.",
                        "https://github.com/oner98/hesap-makinesi-c-/tree/main/hesap%20makinesi"),
                new ProjectResponse("Hava Yolu ve Uçuş Alan Modeli",
                        List.of("Java", "OOP", "Domain Modeling"),
                        "Hava yolu, uçak, pilot, havaalanı ve uçuş kavramlarını sınıflar ve nesne ilişkileriyle modelleyen Java çalışması.",
                        "https://github.com/oner98/U-u-Y-netim-Sistemi"));
    }

    public record ProfileResponse(
            String name,
            String title,
            String email,
            String phone,
            String location,
            String github,
            String linkedin,
            List<String> skills) {
    }

    public record ProjectResponse(String title, List<String> stack, String description, String url) {
    }
}
