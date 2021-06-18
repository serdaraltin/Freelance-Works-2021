Module Module1
    Public Class Kare
        Public Property kenar As Integer

        Public Sub New()
            Console.WriteLine("Yeni nesne turetildi (Kare)")
        End Sub
        Public Sub New(ByVal _kenar As Integer)
            kenar = _kenar
            Console.WriteLine("Parametreli yeni nesne turetildi (Kare)")
        End Sub

        Protected Overrides Sub Finalize()
            Console.WriteLine("Nesne yokedildi (Kare)")
        End Sub

        Public Overridable Function Alan() As Integer
            Return kenar * kenar
        End Function

        Public Overridable Function Cevre() As Integer
            Return kenar * 4
        End Function

    End Class

    Public Class Kup
        Inherits Kare

        Public Sub New()
            Console.WriteLine("Yeni nesne turetildi (Kup)")
        End Sub
        Public Sub New(ByVal _kenar As Integer)
            kenar = _kenar
            Console.WriteLine("Parametreli yeni nesne turetildi (Kup)")
        End Sub

        Protected Overrides Sub Finalize()
            Console.WriteLine("Nesne yokedildi (Kup)")
        End Sub

        Public Overrides Function Alan() As Integer
            Return 6 * (MyBase.Alan())
        End Function

        Public Overrides Function Cevre() As Integer
            Return 3 * (MyBase.Cevre())
        End Function

        Public Function Hacim() As Integer
            Return kenar * (MyBase.Alan())
        End Function

    End Class
    Sub Main()
        Dim kare As Kare = New Kare()
        Dim kup As Kup = New Kup()

        kare.kenar = 2
        kup.kenar = 4



        Console.WriteLine(kare.Alan)
        Console.WriteLine(kup.Alan)
        Console.WriteLine(kup.Cevre)
        Console.WriteLine(kup.Hacim)


        Console.ReadKey()

    End Sub

End Module
