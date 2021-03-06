USE [proyectoTareas]
GO
/****** Object:  Table [dbo].[Impuestos]    Script Date: 10/30/2013 19:01:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Impuestos](
	[idImpuesto] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [nvarchar](50) NOT NULL,
	[porcentaje] [float] NOT NULL,
 CONSTRAINT [PK_Impuestos] PRIMARY KEY CLUSTERED 
(
	[idImpuesto] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Complejidades]    Script Date: 10/30/2013 19:01:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Complejidades](
	[idComplejidad] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[porcentaje] [float] NOT NULL,
 CONSTRAINT [PK_Complejidad] PRIMARY KEY CLUSTERED 
(
	[idComplejidad] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tareas]    Script Date: 10/30/2013 19:01:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tareas](
	[idTarea] [int] NOT NULL,
	[tiempo] [int] NOT NULL,
	[idComplejidad] [int] IDENTITY(1,1) NOT NULL,
	[tareaPadre] [int] NOT NULL,
 CONSTRAINT [PK_Tarea] PRIMARY KEY CLUSTERED 
(
	[idTarea] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Proyectos]    Script Date: 10/30/2013 19:01:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proyectos](
	[idProyecto] [int] IDENTITY(1,1) NOT NULL,
	[idTarea] [int] NOT NULL,
 CONSTRAINT [PK_Proyecto] PRIMARY KEY CLUSTERED 
(
	[idProyecto] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ImpuestosPorTareas]    Script Date: 10/30/2013 19:01:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImpuestosPorTareas](
	[idImpuesto] [int] NOT NULL,
	[idTarea] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK_ImpuestosPorTareas_Impuestos]    Script Date: 10/30/2013 19:01:03 ******/
ALTER TABLE [dbo].[ImpuestosPorTareas]  WITH CHECK ADD  CONSTRAINT [FK_ImpuestosPorTareas_Impuestos] FOREIGN KEY([idImpuesto])
REFERENCES [dbo].[Impuestos] ([idImpuesto])
GO
ALTER TABLE [dbo].[ImpuestosPorTareas] CHECK CONSTRAINT [FK_ImpuestosPorTareas_Impuestos]
GO
/****** Object:  ForeignKey [FK_ImpuestosPorTareas_Tareas]    Script Date: 10/30/2013 19:01:03 ******/
ALTER TABLE [dbo].[ImpuestosPorTareas]  WITH CHECK ADD  CONSTRAINT [FK_ImpuestosPorTareas_Tareas] FOREIGN KEY([idTarea])
REFERENCES [dbo].[Tareas] ([idTarea])
GO
ALTER TABLE [dbo].[ImpuestosPorTareas] CHECK CONSTRAINT [FK_ImpuestosPorTareas_Tareas]
GO
/****** Object:  ForeignKey [FK_Proyectos_Tareas]    Script Date: 10/30/2013 19:01:03 ******/
ALTER TABLE [dbo].[Proyectos]  WITH CHECK ADD  CONSTRAINT [FK_Proyectos_Tareas] FOREIGN KEY([idTarea])
REFERENCES [dbo].[Tareas] ([idTarea])
GO
ALTER TABLE [dbo].[Proyectos] CHECK CONSTRAINT [FK_Proyectos_Tareas]
GO
/****** Object:  ForeignKey [FK_Tareas_Complejidades]    Script Date: 10/30/2013 19:01:03 ******/
ALTER TABLE [dbo].[Tareas]  WITH CHECK ADD  CONSTRAINT [FK_Tareas_Complejidades] FOREIGN KEY([idComplejidad])
REFERENCES [dbo].[Complejidades] ([idComplejidad])
GO
ALTER TABLE [dbo].[Tareas] CHECK CONSTRAINT [FK_Tareas_Complejidades]
GO
