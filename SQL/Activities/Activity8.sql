REM   Script: Activity8





Select customer_id,order_date ,MAX(PURCHASE_AMOUNT) AS "MAXPURCHASE AMOUNT" from orders  
GROUP BY customer_id, order_date  
HAVING MAX(PURCHASE_AMOUNT)  IN (2030,3450,5760,6000);

Select * from orders;

Select customer_id,order_date ,MAX(PURCHASE_AMOUNT) AS "MAXPURCHASE AMOUNT" from orders  
GROUP BY customer_id, order_date  
HAVING "MAXPURCHASE AMOUNT" IN (2030,3450,5760,6000);

Select * from orders;

Select customer_id,order_date ,MAX(PURCHASE_AMOUNT) AS "MAXPURCHASE AMOUNT" from orders  
GROUP BY customer_id, order_date  
HAVING MAX(PURCHASE_AMOUNT) IN (2030,3450,5760,6000);

