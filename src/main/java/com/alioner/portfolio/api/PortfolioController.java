package com.alioner.portfolio.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                new ProjectResponse("Serverless Booking", List.of("AWS", "Lambda", "DynamoDB"),
                        "Etkinlik rezervasyon süreçlerini otomatikleştiren serverless yapı."),
                new ProjectResponse("Android Kotlin Uygulaması", List.of("Android", "Kotlin", "Android Studio"),
                        "Android Studio ile geliştirilmiş temel bir Kotlin mobil uygulaması."),
                new ProjectResponse("Weather App", List.of("REST", "Firebase", "Caching"),
                        "API tabanlı hava durumu uygulaması."),
                new ProjectResponse("School Management", List.of("Java", "Spring", "MySQL"),
                        "Öğrenci, öğretmen ve not yönetimini tek bir sistemde birleştiren kurumsal uygulama."),
                new ProjectResponse("Smart Inventory", List.of("C#", ".NET", "PostgreSQL"),
                        "Stok takibi ve operasyonel raporlamaya odaklı kurumsal çözüm."),
                new ProjectResponse("Yapay Zeka Yardımcısı", List.of("Python", "Chatbot", "Text Analysis"),
                        "Sohbet, metin analizi ve istatistikleri, dosya işlemleri ve kelime sıklığı analizi sunan Python tabanlı yardımcı uygulama."),
                new ProjectResponse("Cloud Deploy Monitor", List.of("Azure", "Monitoring", "DevOps"),
                        "Dağıtım izleme ve hata takibi için bulut monitör çözümü."),
                new ProjectResponse("Microservice Gateway", List.of("Docker", "Kubernetes", "Microservices"),
                        "Mikroservisler arası yönlendirme ve servis yönetimi."),
                new ProjectResponse("Data Insight Hub", List.of("SQL", "Analytics", "Reporting"),
                        "Veri analizi ve karar destek raporlaması için arayüz."));
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

    public record ProjectResponse(String title, List<String> stack, String description) {
    }
}
