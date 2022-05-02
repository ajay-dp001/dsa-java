package LowLoevelSystemDesign.consistenthashing;

import lombok.Getter;

@Getter
public class VirtualNode<T extends Node> implements Node {

  private final T physicalNode;
  private final int replicaIndex;

  public VirtualNode(final T physicalNode, final int replicaIndex) {
    this.physicalNode = physicalNode;
    this.replicaIndex = replicaIndex;
  }

  @Override
  public String getKey() {
    return physicalNode.getKey() + "-" + replicaIndex;
  }

  public boolean isVirtualNodeOf(T pNode) {
    return physicalNode.getKey().equals(pNode.getKey());
  }
}
