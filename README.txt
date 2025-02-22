----Kafka instance'ı EC2 Servisinde çalışıyor. MKS ile yapılandırma için vakit bulamadım.
----İki Servis de ECS(Elastic Container Servis)'de dokcer imajları build edilmiş şekilde çalışıyor.(Sinem hanımın istediği şekilde)
----Kafka versiyonu güncellendi(3.8.1)


-Servislerin docker imajlarına https://hub.docker.com/repositories/alperd411 adresinden erişilebilir.
-Servislerin docker imajı ayağa kardırılırken ortam değişkeni olarak "-e KafkaAddr" key'i ile kafka cluster adresi verilebilir
(Verilmezse default localhost:9092)
-Servislerin AWS ECS kurulumunda'da aynı parametre ile çalıştırılıyor
(ilgili bölümde -e yazmamıza gerek yok çünkü env_var tanımlı alanından girdi istiyor.)
-Servislerin yapılandırmalarının doğruluğu için "http://{public_ip}:8080/test" adresinden konfigurasyon ayarları ve sistem durumu görünütülenebilir. 
