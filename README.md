# ShopPro Kimlik Doğrulama ve Ticaret Servisi

Bu proje, bir e-ticaret uygulaması için temel kimlik doğrulama, ürün yönetimi, sepet ve ödeme işlemlerini yöneten bir Spring Boot tabanlı mikroservis örneğidir.

## ✨ Özellikler

* **Kullanıcı Yönetimi**: Kullanıcı kaydı ve temel kimlik doğrulama işlemleri.
* **Ürün Yönetimi**: Ürünler için CRUD (Oluşturma, Okuma, Güncelleme, Silme) işlemleri. Yönetici (`ADMIN`) rolü gerektiren özel uç noktalar mevcuttur.
* **Sepet Yönetimi**: Kullanıcıların sepete ürün eklemesi, sepetten çıkarması ve sepet içeriklerini görüntülemesi.
* **Ödeme İşlemleri**: Farklı ödeme stratejilerini (Nakit, Kredi Kartı, Cüzdan) destekleyen esnek ödeme sistemi.
* **Mesajlaşma Entegrasyonu**: Kullanıcı kaydı ve sipariş oluşturma gibi olaylar için RabbitMQ kullanarak bildirim ve e-posta gönderimi.
* **Güvenlik**: Spring Security ile temel kimlik doğrulama ve rol tabanlı yetkilendirme.
* **Merkezi Hata Yönetimi**: Uygulama genelinde özel hata yakalama ve standartlaştırılmış hata yanıtları.
* **API Belgelendirme**: SpringDoc OpenAPI entegrasyonu ile otomatik API belgeleri (Swagger UI).

## 🛠️ Kullanılan Teknolojiler

* **Spring Boot 3.5.0**: Uygulama iskeleti ve bağımlılık yönetimi.
* **Spring Data JPA & Hibernate**: Veritabanı ile etkileşim ve ORM.
* **Spring Security**: Güvenlik ve kimlik doğrulama.
* **PostgreSQL**: İlişkisel veritabanı.
* **RabbitMQ**: Mesaj kuyruğu servisi.
* **Lombok**: Boilerplate kodunu azaltmak için yardımcı kütüphane.
* **Maven**: Proje derleme ve bağımlılık yönetimi.
* **SpringDoc OpenAPI**: API belgelendirme için Swagger UI entegrasyonu.

## 🚀 Kurulum ve Çalıştırma

### Önkoşullar

* Java 21
* Maven
* Docker (isteğe bağlı, PostgreSQL ve RabbitMQ'yu hızlıca kurmak için)

### Docker ile Çalıştırma

Eğer PostgreSQL ve RabbitMQ'yu Docker ile çalıştırmak isterseniz:

1.  Proje dizinine gidin.
2.  Aşağıdaki komutu çalıştırın:
    ```bash
    docker-compose up -d
    ```
    Bu komut, `shoppro_postgres` ve `shoppro_rabbitmq` servislerini ayağa kaldıracaktır.

### Yerel Olarak Çalıştırma

Eğer veritabanı ve RabbitMQ'yu yerel olarak kurmak isterseniz, `src/main/resources/application-dev.yml` dosyasındaki yapılandırmayı kullanabilirsiniz.

1.  Proje bağımlılıklarını indirmek ve projeyi derlemek için aşağıdaki komutu çalıştırın:
    ```bash
    mvn clean install
    ```
2.  Uygulamayı başlatmak için:
    ```bash
    mvn spring-boot:run
    ```
    Uygulama `8080` portunda başlayacaktır.

### Günlük Dosyaları

Uygulama günlükleri `logs/app.log` ve `logs/uygulama.log` dosyalarına kaydedilir. Günlükleme, `logback-spring.xml` yapılandırmasına göre günlük olarak döndürülür ve `INFO` seviyesinde çıktı verir.

## 🔗 API Uç Noktaları

* **Kimlik Doğrulama**
    * `POST /api/v1/auth/register`: Yeni kullanıcı kaydı.
    * `GET /api/v1/auth/login`: Kullanıcı girişi.

* **Ürünler**
    * `GET /api/v1/products`: Tüm ürünleri listele.
    * `GET /api/v1/products/{id}`: Belirli bir ürünü ID'ye göre getir.
    * `POST /api/v1/products`: Yeni ürün oluştur (ADMIN rolü gerekli).
    * `PUT /api/v1/products/{id}`: Mevcut bir ürünü güncelle (ADMIN rolü gerekli).

* **Sepet**
    * `POST /api/v1/cart`: Sepete ürün ekle.
    * `DELETE /api/v1/cart/{cartItemId}`: Sepetten ürün çıkar.
    * `GET /api/v1/cart`: Kullanıcının sepetini görüntüle.

* **Ödeme**
    * `POST /api/v1/payment`: Ödeme işlemini gerçekleştir.

## 🤝 Katkıda Bulunma

Katkıda bulunmaktan çekinmeyin! Her türlü katkı memnuniyetle karşılanır.
