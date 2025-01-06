import requests
from bs4 import BeautifulSoup
import re

url = "http://127.0.0.1:5500/week1_WebcrawlingandRegex/problem/problem6.html"
response = requests.get(url) # url에서 HTML 파일을 가져옴.

soup=BeautifulSoup(response.text, 'html.parser') # BeautifulSoup을 사용해서 HTML 파일에서 파싱해서 DOM 트리 형성


ptag=soup.find_all("p")
email=[]
email_pattern = r"\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b"

for i in ptag:
    email.extend(re.findall(email_pattern,i.text))

for i in email:
    print(i)