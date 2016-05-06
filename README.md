# indisbuilding
Semua oprekan dan dapur IndisBuilding ada di sini

Sistem ditanam di pintu peraga IndisBuilding.

Program utama :

1. utama.py --> menggunakan open public broker MQTT broker.mqttdahshboard.com dan iot.eclipse.org, berjalan di sistem lama (platform.indisbuilding.net)
2. utama2-0.py --> menggunakan private broker dari CloudMQTT, lebih reliable, berjalan di sistem baru (platform.indisbuilding.com)


Kelebihan sistem baru : Sudah menggunakan toekn JWT (JSON Web Token) untuk keamanan feedback status nyala/mati ke platform (masih dalam pengembangan, token sudah berhasil di-create baik dari server maupun raspi, tapi token dari raspi belum bisa (baca : belum sempat) dikirim ke server). 

NB : masih perlu cari cara yg lebih efektif untuk menjalankan program utama dan sensing pintu secara simultan supaya tidak saling mengganggu satu sama lain, terutama saat proses pengiriman gambar dari kamera saat pintu dibuka paksa.




Salam,




Faisal Candrasyah,
Founder & CTO IndisBuilding
