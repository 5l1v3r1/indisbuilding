import os
import smtplib
from email.mime.text import MIMEText
from email.mime.image import MIMEImage
from email.mime.multipart import MIMEMultipart

def email():
	fromaddr = "bbic.indisbuilding@gmail.com"
	fromname = "Indisbuilding"
	penerima = ['okyzaprabowo@gmail.com','wahyuputrarama@gmail.com','yokato27@gmail.com','faicanhas@gmail.com','javcod3@gmail.com']
	#penerima = ['faicanhas@gmail.com']
	msg = MIMEMultipart()
	msg['From'] = fromname	
	msg['Subject'] = 'Pemberitahuan dari Pintu Peraga Prototype IndisBuilding'
	msg['To'] = ", ".join(penerima)

	text = MIMEText("Ini dia pelakunya!")
	msg.attach(text)
	#for file in pngfiles:
	fp = open('image1.jpg','rb')
	img = MIMEImage(fp.read())
	fp.close
	img.add_header('Content-Disposition', 'attachment', filename='nahloh.jpg')
	msg.attach(img)

	server = smtplib.SMTP('smtp.gmail.com',587)
	server.starttls()
	server.login(fromaddr, "bbic.building")
	server.sendmail(fromaddr, penerima, msg.as_string())
	server.quit()
	
