Imports System.Xml
Imports System.Xml.XPath

Public Class Form1
    Dim arc As String
    Private Sub ListFiles(ByVal folderPath As String)
        Try
            cb_xml.Items.Clear()
            Dim sep() As String
            Dim nom_arc As String
            Dim cont As Integer
            Dim fileNames = My.Computer.FileSystem.GetFiles(
                folderPath, FileIO.SearchOption.SearchTopLevelOnly, "*.xml")

            For Each fileName As String In fileNames
                sep = fileName.Split(New Char() {"\", "."})
                For Each word As String In sep
                    If word = "xml" Then
                        nom_arc = sep(cont - 1)
                        cb_xml.Items.Add(nom_arc)
                    End If
                    cont = cont + 1
                Next
                cont = 0
            Next

        Catch ex As Exception
            MsgBox(ex.ToString())
        End Try
    End Sub
    Private Sub btn_cargar_Click(sender As Object, e As EventArgs) Handles btn_cargar.Click
        Try
            arc = cb_xml.SelectedItem()
            Dim xml As XmlDocument
            Dim nodelist As XmlNodeList
            Dim nodo As XmlNode

            arc = cb_xml.SelectedItem()
            xml = New XmlDocument
            xml.Load("F:\Matenimientos xml\JXML\xnlsrc\" + arc + ".xml")
            nodelist = xml.SelectNodes("/basededatos/personas")
            For Each nodo In nodelist
                Dim nom = nodo.ChildNodes(0).InnerText
                Dim apell = nodo.ChildNodes(1).InnerText
                Dim email = nodo.ChildNodes(2).InnerText
                Dim dir = nodo.ChildNodes(3).InnerText
                Dim tel = nodo.ChildNodes(4).InnerText
                MsgBox(nom & " " & apell & " " & email & " " & dir & " " & tel)
            Next
        Catch ex As Exception
            MsgBox(ex.ToString())
        End Try
    End Sub

    Private Sub btn_actualizar_Click(sender As Object, e As EventArgs) Handles btn_actualizar.Click




    End Sub

    Private Sub btn_insert_Click(sender As Object, e As EventArgs) Handles btn_insert.Click
        arc = cb_xml.SelectedItem()
        Dim xml As XmlDocument
        arc = cb_xml.SelectedItem()
        xml = New XmlDocument
        xml.Load("F:\Matenimientos xml\JXML\xnlsrc\" + arc + ".xml")
        Dim root As XmlNode = xml.DocumentElement

        Dim nom As XmlElement = xml.CreateElement("nombre")
        nom.InnerText = "clodomiro"
        Dim ape As XmlElement = xml.CreateElement("apellidos")
        ape.InnerText = "picado"
        Dim mail As XmlElement = xml.CreateElement("email")
        mail.InnerText = "clopicado@gmail.com"
        Dim dir As XmlElement = xml.CreateElement("direccion")
        dir.InnerText = "panama"
        Dim tel As XmlElement = xml.CreateElement("telefono")
        tel.InnerText = "89898989"
        'Create a new node.
        Dim elem As XmlElement = xml.CreateElement("personas")
        elem.AppendChild(nom)
        elem.AppendChild(ape)
        elem.AppendChild(mail)
        elem.AppendChild(dir)
        elem.AppendChild(tel)
        'Add the node to the document InnerText = "19.95".
        root.AppendChild(elem)

        Console.WriteLine("guardando")
        xml.Save("F:\Matenimientos xml\JXML\xnlsrc\" + arc + ".xml")

    End Sub

    Private Sub btn_update_Click(sender As Object, e As EventArgs) Handles btn_update.Click
        arc = cb_xml.SelectedItem()
        Dim document As XmlDocument = New XmlDocument()
        document.Load("F:\Matenimientos xml\JXML\xnlsrc\" + arc + ".xml")
        Dim navigator As XPathNavigator = document.CreateNavigator()

        Dim manager As XmlNamespaceManager = New XmlNamespaceManager(navigator.NameTable)
        manager.AddNamespace("bd", "test")


        For Each nav As XPathNavigator In navigator.Select("//bd:nombre", manager)
            If nav.Value = "clodomiro" Then
                nav.SetValue("mario")
            End If
        Next


    End Sub

    Private Sub btn_delete_Click(sender As Object, e As EventArgs) Handles btn_delete.Click
        arc = cb_xml.SelectedItem()
        Dim xml As XmlDocument
        Dim nodelist As XmlNodeList
        Dim nodelisb As XmlNodeList
        Dim nodo As XmlNode
        Dim nude As XmlNode
        arc = cb_xml.SelectedItem()
        xml = New XmlDocument
        xml.Load("F:\Matenimientos xml\JXML\xnlsrc\" + arc + ".xml")
        Dim root As XmlNode = xml.DocumentElement
        nodelist = xml.SelectNodes("/basededatos/personas")
        For Each nodo In nodelist
            Dim num = nodo.ChildNodes(0).InnerText
            If num.Equals("clodomiro") Then
                root.RemoveChild(nodo)
            End If

        Next
        Console.WriteLine("guardando")
        xml.Save("F:\Matenimientos xml\JXML\xnlsrc\" + arc + ".xml")

    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Dim path As String
        path = "F:\Matenimientos xml\JXML\xnlsrc"
        ListFiles(path)

    End Sub
End Class
