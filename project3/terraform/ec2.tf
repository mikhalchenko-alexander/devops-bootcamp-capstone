data "aws_ami" "amazon_linux" {
  most_recent = true

  filter {
    name = "image-id"
    values = ["ami-089dc6fe381a457ca"]
  }

  filter {
    name = "virtualization-type"
    values = ["hvm"]
  }

  owners = ["amazon"]
}

data "aws_vpc" "default" {
  default = true
}

resource "aws_security_group" "java_app" {
  name   = "java-app-sg"
  vpc_id = data.aws_vpc.default.id
  tags = {
    Name = "Java app"
  }
}

resource "aws_vpc_security_group_ingress_rule" "java_app_ingress" {
  security_group_id = aws_security_group.java_app.id
  cidr_ipv4         = "0.0.0.0/0"
  from_port         = 8080
  ip_protocol       = "tcp"
  to_port           = 8080
}

resource "aws_vpc_security_group_ingress_rule" "ssh_ingress" {
  security_group_id = aws_security_group.java_app.id
  cidr_ipv4         = "0.0.0.0/0"
  from_port         = 22
  ip_protocol       = "tcp"
  to_port           = 22
}

resource "aws_vpc_security_group_egress_rule" "egress_all" {
  security_group_id = aws_security_group.java_app.id
  cidr_ipv4         = "0.0.0.0/0"
  ip_protocol       = -1
}

resource "aws_instance" "java-app-instance" {
  ami                         = data.aws_ami.amazon_linux.id
  instance_type = "t4g.micro"
  key_name                    = "devops-bootcamp"
  security_groups = [aws_security_group.java_app.name]
  associate_public_ip_address = true

  user_data = file("entry-script.sh")
  user_data_replace_on_change = true

  tags = {
    Name = "Capstone 3"
  }
}

output "ec2-public_ip" {
  value = aws_instance.java-app-instance.public_ip
}
