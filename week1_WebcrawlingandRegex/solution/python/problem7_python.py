import requests
from bs4 import BeautifulSoup
import re

url = "http://127.0.0.1:5500/problem7.html"
response = requests.get(url) # url에서 HTML 파일을 가져옴.

soup=BeautifulSoup(response.text, 'html.parser') # BeautifulSoup을 사용해서 HTML 파일에서 파싱해서 DOM 트리 형성


ptag=soup.find_all("p")
date=[]
date_pattern = r"\b\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2][0-9]|3[0-1])"

for i in ptag:
    date.extend(re.findall(date_pattern,i.text))

for i in date:
    print(i)
