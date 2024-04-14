SELECT product_name
FROM CUSTOMERS A
JOIN ORDERS B
ON A.id = B.customer_id
WHERE UPPER(A.name) = UPPER(:name);