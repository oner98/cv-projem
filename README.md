# CV Projem

Kişisel portfolyo, CV ve Spring Boot REST API.

## Teknolojiler

- Java 21 ve Spring Boot 3.5
- Spring Web, Bean Validation, Spring Data JPA ve Flyway
- Yerel geliştirme için dosya tabanlı H2; dağıtım için PostgreSQL
- HTML5, Tailwind CSS ve Font Awesome

## Gereksinimler

- Java 21

## Yerel çalıştırma

```powershell
.\mvnw.cmd spring-boot:run
```

Maven Wrapper gerekli Maven sürümünü otomatik indirir. Uygulama
`http://localhost:8080` adresinde portfolyo sayfasını ve REST API'yi birlikte
sunar. Testleri `.\mvnw.cmd test` komutuyla çalıştırabilirsiniz.

Alternatif olarak, sayfayı VS Code Live Server ile `http://localhost:5500`
adresinde açabilirsiniz; API yine `localhost:8080` üzerinden çalışır.

Yerel veritabanı `data/portfolio` altında saklanır. Şema ilk çalıştırmada
Flyway tarafından oluşturulur.

## API

- `GET /api/profile` — portfolyo profil bilgileri
- `GET /api/projects` — proje listesi
- `POST /api/contact` — iletişim formu mesajını doğrular ve veritabanına kaydeder
- `GET /actuator/health` — uygulama sağlık durumu

İletişim isteği örneği:

```json
{
  "name": "Ad Soyad",
  "email": "ornek@email.com",
  "message": "En az 10 karakter uzunluğunda bir mesaj."
}
```

Ad, e-posta ve mesaj alanları zorunludur. Mesaj uzunluğu 10–5000 karakter
arasında olmalıdır. İletişim mesajlarını listeleyen herkese açık bir API
bulunmaz.

## Yapılandırma

| Ortam değişkeni | Varsayılan | Açıklama |
| --- | --- | --- |
| `PORT` | `8080` | HTTP sunucu portu |
| `DATABASE_URL` | `jdbc:h2:file:./data/portfolio` | JDBC veritabanı bağlantı adresi |
| `DB_USERNAME` | `sa` | Veritabanı kullanıcısı |
| `DB_PASSWORD` | boş | Veritabanı parolası |
| `CORS_ALLOWED_ORIGINS` | `http://localhost:5500,http://127.0.0.1:5500` | Virgülle ayrılmış, izin verilen web adresleri |

Canlı web sayfasını ayrı bir sunucuda barındırıyorsanız, `index.html` içindeki
`api-base-url` meta etiketine API adresini yazın ve dağıtım ortamında
`CORS_ALLOWED_ORIGINS` değişkenine web sayfasının tam adresini ekleyin.
GitHub Pages statik sayfaları tek başına Spring Boot API'sini çalıştıramaz;
backend ayrıca bir Java sunucusuna dağıtılmalıdır.

## Canlı demo ve kaynak kodu

- Portfolyo: <https://oner98.github.io/cv-projem/>
- GitHub: <https://github.com/oner98/cv-projem>
