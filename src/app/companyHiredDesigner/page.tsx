import DesignerCard from "@/components/DesignerCard";
import "./companyHiredDesigner.page.scss";
import ContainerHeader from "@/components/ContainerHeader";
export default function Home() {
  return (
    <div className="content hired">
      <ContainerHeader h3={"고용중인 디자이너"} p={"고용된 디자이너의 근로상태 또는 할당된 일감을 확인하세요."}/>
      <section>
        <DesignerCard/>
        <DesignerCard/>
        <DesignerCard/>
        <DesignerCard/>
        <DesignerCard/>
        <DesignerCard/>
      </section>
    </div>
  );
}
