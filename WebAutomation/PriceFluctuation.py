# Create a price fluctuation model to analyze e-Commerce
# providers. Selenium can explore the products and click
# for you. Information will be stored in CSV files

from selenium import webdriver
from selenium.webdriver.common.by import by
from selenium.webdriver.support import expected_conditions as EC 
from selenium.common.exceptions import TimeoutException

driver = webdriver.Chrome(executable_path="/mnt/c/Users/Public/chromedriver_win32 (1)/chromedriver.exe")
driver.get('https://www.lazada.sg/#')

# Wait for page to load and find the element
# Stop the wait until Excepted Conditions (EC) is met to find
# by ID "Level_1_Category_No1". If 30 secs passed without
# such element, TimeoutException shuts down the browser
timeout = 30
try:
    WebDriverWait(driver.timeout).until(EC.visibility_of_element_located((by.ID, "Level_1_Category_No1")))
except TimeoutException:
    driver.quit()