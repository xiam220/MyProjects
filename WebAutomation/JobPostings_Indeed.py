# Create a program to analyze desired qualifications
# for entry level tech positions on Indeed

from selenium import webdriver
from selenium.webdriver.common.by import By 
from selenium.webdriver.support import expected_conditions as EC 
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.support.ui import WebDriverWait

from bs4 import BeautifulSoup
import time
import pandas as pd

options = webdriver.ChromeOptions()
options.add_argument('--ignore-certificate-errors')
options.add_argument('--incognito')
driver = webdriver.Chrome(executable_path="/mnt/c/Users/Public/chromedriver_win32 (1)/chromedriver.exe", chrome_options=options)
driver.get("https://www.indeed.com/jobs?q=software+engineer+entry+level&l=")

# Wait for page to load and find the job posting card
timeout = 30
try:
    WebDriverWait(driver, timeout).until(EC.visibility_of_element_located((By.ID, "resultsCol")))
except TimeoutException:
    driver.quit()

# Retrieve job card preview information
"""
list_table_elements = driver.find_element(By.XPATH, "//table[@id='pageContent']/tbody/tr//td[@id='resultsCol']")
job_card = list_table_elements.find_elements(By.CLASS_NAME, "jobsearch-SerpJobCard")
for card in job_card:
    print(card.text + "\n")
"""

# Click through the links to access full job description
# HTML Parsing
elements = driver.find_elements_by_class_name('jobtitle')
page_source = driver.page_source
soup = BeautifulSoup(page_source, 'html.parser')
# jobTitles = soup.find_all('div', class_='jobsearch-JobInfoHeader-title-container')
jobTitles = driver.find_elements(By.XPATH, "//*[@data-tn-element='jobTitle']")
job_title = []
for jobNum, link in enumerate(elements):
    webdriver.ActionChains(driver).move_to_element(link).click(link).perform()
    title = jobTitles[jobNum].text
    job_title.append(title)
    time.sleep(1)

# HTML Parsing with BeautifulSoup
"""
page_source = driver.page_source
soup = BeautifulSoup(page_source, 'html.parser')
job_containers = soup.find_all('div', id='vjs-container')
job_title = []
print(len(job_containers))
# for container in job_containers:
#     title = container.find('h3', class_='jobsearch-JobInfoHeader-title').get_text()
#     print(title)
# print(job_title)
"""