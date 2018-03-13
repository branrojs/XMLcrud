<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form reemplaza a Dispose para limpiar la lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Requerido por el Diseñador de Windows Forms
    Private components As System.ComponentModel.IContainer

    'NOTA: el Diseñador de Windows Forms necesita el siguiente procedimiento
    'Se puede modificar usando el Diseñador de Windows Forms.  
    'No lo modifique con el editor de código.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.btn_cargar = New System.Windows.Forms.Button()
        Me.btn_actualizar = New System.Windows.Forms.Button()
        Me.btn_insert = New System.Windows.Forms.Button()
        Me.btn_update = New System.Windows.Forms.Button()
        Me.btn_delete = New System.Windows.Forms.Button()
        Me.cb_xml = New System.Windows.Forms.ComboBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.txt_nom = New System.Windows.Forms.TextBox()
        Me.txt_apell = New System.Windows.Forms.TextBox()
        Me.txt_corr = New System.Windows.Forms.TextBox()
        Me.txt_dir = New System.Windows.Forms.TextBox()
        Me.txt_tel = New System.Windows.Forms.TextBox()
        Me.SuspendLayout()
        '
        'btn_cargar
        '
        Me.btn_cargar.Location = New System.Drawing.Point(357, 26)
        Me.btn_cargar.Name = "btn_cargar"
        Me.btn_cargar.Size = New System.Drawing.Size(75, 23)
        Me.btn_cargar.TabIndex = 0
        Me.btn_cargar.Text = "Cargar"
        Me.btn_cargar.UseVisualStyleBackColor = True
        '
        'btn_actualizar
        '
        Me.btn_actualizar.Location = New System.Drawing.Point(438, 26)
        Me.btn_actualizar.Name = "btn_actualizar"
        Me.btn_actualizar.Size = New System.Drawing.Size(75, 23)
        Me.btn_actualizar.TabIndex = 1
        Me.btn_actualizar.Text = "Actualizar"
        Me.btn_actualizar.UseVisualStyleBackColor = True
        '
        'btn_insert
        '
        Me.btn_insert.Location = New System.Drawing.Point(276, 295)
        Me.btn_insert.Name = "btn_insert"
        Me.btn_insert.Size = New System.Drawing.Size(75, 23)
        Me.btn_insert.TabIndex = 2
        Me.btn_insert.Text = "Agregar"
        Me.btn_insert.UseVisualStyleBackColor = True
        '
        'btn_update
        '
        Me.btn_update.Location = New System.Drawing.Point(357, 295)
        Me.btn_update.Name = "btn_update"
        Me.btn_update.Size = New System.Drawing.Size(75, 23)
        Me.btn_update.TabIndex = 3
        Me.btn_update.Text = "Modificar"
        Me.btn_update.UseVisualStyleBackColor = True
        '
        'btn_delete
        '
        Me.btn_delete.Location = New System.Drawing.Point(438, 295)
        Me.btn_delete.Name = "btn_delete"
        Me.btn_delete.Size = New System.Drawing.Size(75, 23)
        Me.btn_delete.TabIndex = 4
        Me.btn_delete.Text = "Eliminar"
        Me.btn_delete.UseVisualStyleBackColor = True
        '
        'cb_xml
        '
        Me.cb_xml.FormattingEnabled = True
        Me.cb_xml.Location = New System.Drawing.Point(29, 26)
        Me.cb_xml.Name = "cb_xml"
        Me.cb_xml.Size = New System.Drawing.Size(322, 21)
        Me.cb_xml.TabIndex = 5
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(32, 73)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(47, 13)
        Me.Label1.TabIndex = 6
        Me.Label1.Text = "Nombre:"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(32, 123)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(52, 13)
        Me.Label2.TabIndex = 7
        Me.Label2.Text = "Apellidos:"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(32, 170)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(41, 13)
        Me.Label3.TabIndex = 8
        Me.Label3.Text = "Correo:"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(32, 255)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(52, 13)
        Me.Label4.TabIndex = 9
        Me.Label4.Text = "Teléfono:"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(32, 212)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(55, 13)
        Me.Label5.TabIndex = 10
        Me.Label5.Text = "Dirección:"
        '
        'txt_nom
        '
        Me.txt_nom.Location = New System.Drawing.Point(121, 70)
        Me.txt_nom.Name = "txt_nom"
        Me.txt_nom.Size = New System.Drawing.Size(322, 20)
        Me.txt_nom.TabIndex = 11
        '
        'txt_apell
        '
        Me.txt_apell.Location = New System.Drawing.Point(121, 116)
        Me.txt_apell.Name = "txt_apell"
        Me.txt_apell.Size = New System.Drawing.Size(322, 20)
        Me.txt_apell.TabIndex = 12
        '
        'txt_corr
        '
        Me.txt_corr.Location = New System.Drawing.Point(121, 163)
        Me.txt_corr.Name = "txt_corr"
        Me.txt_corr.Size = New System.Drawing.Size(322, 20)
        Me.txt_corr.TabIndex = 13
        '
        'txt_dir
        '
        Me.txt_dir.Location = New System.Drawing.Point(121, 209)
        Me.txt_dir.Name = "txt_dir"
        Me.txt_dir.Size = New System.Drawing.Size(322, 20)
        Me.txt_dir.TabIndex = 14
        '
        'txt_tel
        '
        Me.txt_tel.Location = New System.Drawing.Point(121, 252)
        Me.txt_tel.Name = "txt_tel"
        Me.txt_tel.Size = New System.Drawing.Size(322, 20)
        Me.txt_tel.TabIndex = 15
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(540, 341)
        Me.Controls.Add(Me.txt_tel)
        Me.Controls.Add(Me.txt_dir)
        Me.Controls.Add(Me.txt_corr)
        Me.Controls.Add(Me.txt_apell)
        Me.Controls.Add(Me.txt_nom)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.cb_xml)
        Me.Controls.Add(Me.btn_delete)
        Me.Controls.Add(Me.btn_update)
        Me.Controls.Add(Me.btn_insert)
        Me.Controls.Add(Me.btn_actualizar)
        Me.Controls.Add(Me.btn_cargar)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents btn_cargar As System.Windows.Forms.Button
    Friend WithEvents btn_actualizar As System.Windows.Forms.Button
    Friend WithEvents btn_insert As System.Windows.Forms.Button
    Friend WithEvents btn_update As System.Windows.Forms.Button
    Friend WithEvents btn_delete As System.Windows.Forms.Button
    Friend WithEvents cb_xml As System.Windows.Forms.ComboBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents txt_nom As System.Windows.Forms.TextBox
    Friend WithEvents txt_apell As System.Windows.Forms.TextBox
    Friend WithEvents txt_corr As System.Windows.Forms.TextBox
    Friend WithEvents txt_dir As System.Windows.Forms.TextBox
    Friend WithEvents txt_tel As System.Windows.Forms.TextBox

End Class
