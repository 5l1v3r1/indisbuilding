# indisbuilding
Semua oprekan dan dapur IndisBuilding ada di sini

Sistem ditanam di pintu peraga IndisBuilding.

Program utama :

1. utama.py --> menggunakan open public broker MQTT broker.mqttdahshboard.com dan iot.eclipse.org, berjalan di sistem lama (platform.indisbuilding.net)
2. utama2-0.py --> menggunakan private broker dari CloudMQTT, lebih reliable, berjalan di sistem baru (platform.indisbuilding.com)


Kelebihan sistem baru : Sudah menggunakan toekn JWT (JSON Web Token) untuk keamanan feedback status nyala/mati ke platform (masih dalam pengembangan, token sudah berhasil di-create baik dari server maupun raspi, tapi token dari raspi belum bisa (baca : belum sempat) dikirim ke server). 

NB : 
1. Masih perlu cari cara yg lebih efektif untuk menjalankan program utama dan sensing pintu secara simultan supaya tidak saling mengganggu satu sama lain, terutama saat proses pengiriman gambar dari kamera saat pintu dibuka paksa.

2. Perlu teknik kompresi gambar (sementara akan dicoba via PIL (Python Image Library)) untuk mengecilkan ukuran gambar tanpa mengurangi kualitas gambar secara signifikan. Rata-rata ukuran gambar hasil jepret kamera memakan sekitar 200-300 kB. Ini tentu besar dan memerlukan waktu lama untuk upload jika koneksi tidak stabil dan lambat. Ditargetkan ukuran file bisa direduksi hingga puluhan KB (20-30 KB), bahkan kalau bisa hanya belasan atau satuan KB saja.




Salam,




Faisal Candrasyah,
Founder & CTO IndisBuilding
