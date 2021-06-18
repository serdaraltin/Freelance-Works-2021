Begin Transaction
Begin Try

Update personel set maas=0
Where Id=1

Update personel set maas=3000
Where Id=1

Commit
End Try
Begin Catch
Rollback
End Catch