# Create a program to analyze desired qualifications
# for entry level tech positions on Indeed

from selenium import webdriver
from selenium.webdriver.common.by import By 
from selenium.webdriver.support import expected_conditions as EC 
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.support.ui import WebDriverWait
import pandas as pd

options = webdriver.ChromeOptions()
options.add_argument('--ignore-certificate-errors')
options.add_argument('--incognito')
driver = webdriver.Chrome(executable_path="/mnt/c/Users/Public/chromedriver_win32 (1)/chromedriver.exe", chrome_options=options)
driver.get("https://www.indeed.com/jobs?q=software%20engineer%20entry%20level&advn=1515350661095281&vjk=bf7f0c38fb8101aa")

# Wait for page to load and find the job posting card

timeout = 30
try:
    WebDriverWait(driver, timeout).until(EC.visibility_of_element_located((By.ID, "resultsCol")))
except TimeoutException:
    driver.quit()

# Gives you the first card?
job_card = driver.find_element_by_class_name('jobsearch-SerpJobCard') 

