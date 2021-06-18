Module soru1
    Public Class OrnekSinif
        Public Function Toplama(ByVal a As Integer, ByVal b As Integer) As Integer
            Return a + b
        End Function

        Public Function Toplama(ByVal a As Integer, ByVal b As Integer, ByVal c As Integer) As Integer
            Return a + b + c
        End Function
    End Class

    Sub Main()
        Dim yeni As OrnekSinif = New OrnekSinif()
        Console.WriteLine(yeni.Toplama(1, 2))
        Console.WriteLine(yeni.Toplama(1, 2, 3))
        Console.ReadKey()
    End Sub
End Module
