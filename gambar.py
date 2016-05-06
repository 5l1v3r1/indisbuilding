import smtplib
from email.MIMEMultipart import MIMEMultipart
from email.MIMEText import MIMEText
from email.mime.image import MIMEImage

def kirim(toadr, mailsub, body):
	fromaddr = "bbic.indisbuilding@gmail.com"
	fromname = "Indisbuilding"
	
	msg = MIMEMultipart()
	msg['From'] = fromname
	msg['To'] = toadr
	msg['Subject'] = mailsub

	msg.attach(MIMEText(body, 'plain'))
	server = smtplib.SMTP('smtp.gmail.com',587)
	server.starttls()
	server.login(fromaddr, "bbic.building")
	text = msg.as_string()
	image = MIMEImage(img_data, name=os.path.basename(cat.py))
	msg.attach(image)
	server.sendmail(fromaddr, toadr, text)
	server.quit()
