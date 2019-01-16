# Write your MySQL query statement below
select P.FirstName    as FirstName,P.LastName as LastName,A.City as City,A.State as State
from (select * from Person) P
left outer join (select * from Address) A on P.PersonId = A.PersonId
