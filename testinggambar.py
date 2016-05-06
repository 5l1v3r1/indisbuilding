import os
import smtplib
from email.mime.text import MIMEText
from email.mime.image import MIMEImage
from email.mime.multipart import MIMEMultipart


img_data = open('cat.png', 'rb').read()
fromaddr = "bbic.indisbuilding@gmail.com"
fromname = "Indisbuilding"

msg = MIMEMultipart()
msg['From'] = fromaddr	
msg['Subject'] = 'Notifikasi rumah cerdas'
msg['To'] = 'ceceraraa@gmail.com'

text = MIMEText("test")
msg.attach(text)

fp = open('cat.png', 'rb')
msgImage = MIMEImage(fp.read())
fp.close()


server = smtplib.SMTP('smtp.gmail.com',587)
server.startls()
server.login(fromaddr, "bbic.building")
server.sendmail(fromaddr, To, msg.as_string())
server.quit()
	

