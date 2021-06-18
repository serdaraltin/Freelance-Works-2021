SELECT        dbo.departman.ad AS 'Departman Adı', dbo.personel.tcNo, dbo.personel.ad AS Expr1, dbo.personel.soyad, dbo.personel.maas
FROM            dbo.departman INNER JOIN
                         dbo.personel ON dbo.departman.Id = dbo.personel.Id