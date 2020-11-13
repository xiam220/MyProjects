# Create a program to analyze desired qualifications
# for entry level tech positions on Indeed

from selenium import webdriver
from selenium.webdriver.common.by import By 
from selenium.webdriver.support import expected_conditions as EC 
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.support.ui import WebDriverWait
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
# list_table_elements = driver.find_element(By.XPATH, "//table[@id='pageContent']/tbody/tr//td[@id='resultsCol']")
# job_card = list_table_elements.find_elements(By.CLASS_NAME, "jobsearch-SerpJobCard")
# for card in job_card:
#     print(card.text + "\n")

# Click through the links to access full job description
elements = driver.find_elements_by_class_name('jobtitle')
for link in elements:
    webdriver.ActionChains(driver).move_to_element(link).click(link).perform()
    time.sleep(3)