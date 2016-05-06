import smtplib
from email.MIMEMultipart import MIMEMultipart
from email.MIMEText import MIMEText
from email.mime.image import MIMEImage

def email(text2):
	fromaddr = "bbic.indisbuilding@gmail.com"
	fromname = "IndisBuilding"
	#penerima = ['faicanhas@gmail.com']
	penerima = ['okyzaprabowo@gmail.com','wahyuputrarama@gmail.com','yokato27@gmail.com','faicanhas@gmail.com','javcod3@gmail.com']
	
	msg = MIMEMultipart()
	msg['From'] = fromname
	msg['To'] = ", ".join(penerima)
	msg['Subject'] = 'Pemberitahuan dari Pintu Peraga Prototype IndisBuilding'

	text1 = "Peringatan! \nStatus : \nPintu rumah Anda dibuka dengan paksa! \nAlarm dinyalakan. \n"
	#text2  = "nyala"
	pesan = MIMEText(text1 + text2)
	msg.attach(pesan)

	server = smtplib.SMTP('smtp.gmail.com',587)
	server.starttls()
	server.login(fromaddr, "bbic.building")
	server.sendmail(fromaddr, penerima, msg.as_string())
	server.quit()

email("Gambar pelaku sedang dikirim...")

