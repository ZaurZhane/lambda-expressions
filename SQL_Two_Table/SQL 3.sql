SELECT product_name
FROM CUSTOMER A
JOIN ORDERS B
ON A.id = B.customer_id
WHERE UPPER(A.name) = UPPER('alexey');