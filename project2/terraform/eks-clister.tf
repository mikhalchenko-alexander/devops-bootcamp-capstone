module "eks" {
  source  = "terraform-aws-modules/eks/aws"
  version = "19.17.2"

  cluster_name                   = "java-app-eks-cluster"
  cluster_version = "1.34"
  cluster_endpoint_public_access = true

  subnet_ids = module.java-app-vpc.private_subnets
  vpc_id     = module.java-app-vpc.vpc_id

  tags = {
    environment = "development"
    application = "java-app"
  }

  eks_managed_node_groups = {
    dev = {
      min_size     = 1
      max_size     = 3
      desired_size = 3

      instance_types = ["t3.small"]
    }
  }
}
