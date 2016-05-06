from email.mime.image import MIMEImage
from kirimemail import kirim

#toaddr = ['faicanhas@gmail.com','faicanhas@yahoo.co.id','faicanhas@hotmail.com']
toaddr = ['okyzaprabowo@gmail.com','wahyuputrarama@gmail.com','ceceraraa@gmail.com','faicanhas@gmail.com']
subjectmail = "Notifikasi Rumah Cerdas"
body = "Peringatan! Pintu rumah Anda terbuka!"

kirim(toaddr, subjectmail, body)
