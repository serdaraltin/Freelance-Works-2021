Public Class Hesapla
    Public Function BasariNotu(ByVal vize1 As Integer, ByVal vize2 As Integer, ByVal final As Integer) As Integer
        Dim vizeNot As Integer = ((vize1 / 100) * 40) + ((vize2 / 100) * 40)
        Dim finalNot As Integer = (final / 100) * 60
        Return vizeNot + finalNot
    End Function

End Class
