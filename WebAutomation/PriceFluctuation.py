# Create a price fluctuation model to analyze e-Commerce
# providers. Selenium can explore the products and click
# for you. Information will be stored in CSV files

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC 
from selenium.common.exceptions import TimeoutException

from selenium.webdriver.support.ui import WebDriverWait
import pandas as pd 
options = webdriver.ChromeOptions()
options.add_argument('--ignore-certificate-errors')
options.add_argument('--incognito')
# options.add_argument('--headless')
driver = webdriver.Chrome(executable_path="/mnt/c/Users/Public/chromedriver_win32 (1)/chromedriver.exe", chrome_options=options)
driver.get('https://www.lazada.sg/#')

# Wait for page to load and find the element
# Stop the wait until Excepted Conditions (EC) is met to find
# by ID "Level_1_Category_No1". If 30 secs passed without
# such element, TimeoutException shuts down the browser


timeout = 30
try:
    WebDriverWait(driver, timeout).until(EC.visibility_of_element_located((By.ID, "Level_1_Category_No1")))
except TimeoutException:
    driver.quit()

# Return the relevant category listing
category_element = driver.find_element(By.ID, 'Level_1_Category_No1').text
# print(type(category_element))

list_category_elements = driver.find_element(By.XPATH, '//*[@id="J_icms-5000498-1511516689962"]/div/ul')
links = list_category_elements.find_elements(By.CLASS_NAME, "lzd-site-menu-root-item")
# for i in range(len(links)):
#     print(links[i].text)

# Mimic a click
element = driver.find_elements_by_class_name('J_ChannelsLink')[2]
# print(element)

webdriver.ActionChains(driver).move_to_element(element).click(element).perform()

# # Create lists of product title
# product_titles = driver.find_elements_by_class_name('title')
# for title in product_titles:
#     print(title.text)

# Extract the product title, pack size, price, and rating
product_containers = driver.find_elements_by_class_name('product_container')
product_titles = list()
pack_sizes = list()
product_prices = list()
rating_counts = list()
for container in product_containers:
    # print(container)
    print(product_titles.append(container.driver.find_elements_by_class_name('title').text))
    # product_titles.append(container.find_elements_by_class_name('title').text)
    # pack_sizes.append(container.find_elements_by_class_name('pack_size').text)
    # product_prices.append(container.find_elements_by_class_name('product_price').text)
    # rating_counts.append(container.find_elements_by_class_name('ratings_count').text)
# data = {'product_title': product_titles, 'product_prices': product_prices, 'rating_counts': rating_counts}

# df_product = pd.DataFrame.from_dict(data)
# df_product.to_csv('product_indo.csv')
# print(product_prices)