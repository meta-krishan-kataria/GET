use E_Com_DB;
select * from product;
select p.Product_Id , p.Product_Name , IFNULL(m.Product_Name , 'Top Category') as Parent_Category from product p LEFT JOIN  product m
ON p.Parent_Id = m.Product_Id ;
select p.Product_Id , p.Product_Name , IFNULL(m.Product_Name , 'Top Category') as Parent_Category from product p LEFT JOIN  product m
ON p.Parent_Id = m.Product_Id order by Parent_Category;
select Product_Name from product where Parent_Id is null ;